package com.feilong.gulimall.product;

import com.feilong.gulimall.product.entity.BrandEntity;
import com.feilong.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/15 12:47
 */
@SpringBootApplication
@SuppressWarnings("ALL")
@Slf4j
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }
}
