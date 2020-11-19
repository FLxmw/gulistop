package com.feilong.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feilong.common.utils.PageUtils;
import com.feilong.common.utils.Query;

import com.feilong.gulimall.product.dao.CategoryDao;
import com.feilong.gulimall.product.entity.CategoryEntity;
import com.feilong.gulimall.product.service.CategoryService;


@Service("categoryService")
@SuppressWarnings("ALL")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 找出所有一級分類
     *
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查出所有的分類列表
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2.組裝成父子的樹形結構
        //2.1  找到所有的一级分类
        List<CategoryEntity> levelMenus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                }).sorted((menu1, menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());

                }).collect(Collectors.toList());
        return levelMenus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 待办：检查当前的菜单是否被别的地方所引用
        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    //递归查出所有菜单的子菜单
    public List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            //1.找到了子菜單
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //2.菜單的排序
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }


}