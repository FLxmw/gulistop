package com.feilong.gulimall.product.service;

import com.feilong.gulimall.product.entity.BrandEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/15 12:42
 */
@SuppressWarnings("ALL")
@Slf4j
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Test
    public void test1(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("哈哈");
        boolean result = brandService.save(brandEntity);
        log.info("新增的结果为："+result);
    }
    

}