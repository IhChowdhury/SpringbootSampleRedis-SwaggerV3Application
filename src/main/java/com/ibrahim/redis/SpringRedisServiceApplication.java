package com.ibrahim.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisServiceApplication.class, args);
    }

}
