package com.ycz.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: hyczzz
 * @date: 2019/12/8 0008 21:12
 * @description:
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {

        SpringApplication.run(ZuulGatewayApplication.class,args);
    }
}
