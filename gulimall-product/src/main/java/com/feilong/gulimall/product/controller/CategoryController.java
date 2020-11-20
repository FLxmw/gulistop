package com.feilong.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feilong.gulimall.product.entity.CategoryEntity;
import com.feilong.gulimall.product.service.CategoryService;
import com.feilong.common.utils.PageUtils;
import com.feilong.common.utils.R;

import javax.validation.Valid;


/**
 * 商品三级分类
 *
 * @author xiaomingwang
 * @email xiaomingwang@gmail.com
 * @date 2020-11-13 12:45:43
 */
@RestController
@RequestMapping("product/category")
@SuppressWarnings("ALL")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = categoryService.queryPage(params);
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        return R.ok().put("data", categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@Valid @RequestBody CategoryEntity category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            Map<String,String> map=new HashMap<>();
            //获取错误的校验结果
            bindingResult.getFieldErrors().forEach((item)->{
                //得到出现错误的字段
                String field = item.getField();
                //得到錯誤的message信息
                String message = item.getDefaultMessage();
                map.put(field,message);

            });
            return R.error(400,"提交的数据不合法！").put("data",map);
        }
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }
    @RequestMapping("/update/sort")
    //@RequiresPermissions("product:category:update")
    public R updateSort(@RequestBody CategoryEntity[] category) {
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds) {
//        categoryService.removeByIds(Arrays.asList(catIds));
         //刪除之前需要判断待删除的菜单是否被别的地方所引用
        categoryService.removeMenuByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
