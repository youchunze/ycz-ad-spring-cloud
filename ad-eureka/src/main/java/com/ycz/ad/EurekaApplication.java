package com.ycz.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: hyczzz
 * @date: 2019/12/8 0008 20:12
 * @description: EurekaServer
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class,args);
    }
}
