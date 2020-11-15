package com.feilong.gulimall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/15 12:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("ALL")
public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }
}
