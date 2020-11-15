package com.feilong.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author FeiLong
 * @version 1.8
 * @date 2020/11/15 12:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("ALL")
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }
}
