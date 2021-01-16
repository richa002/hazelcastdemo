package com.example.hazelcastcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastCachedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastCachedemoApplication.class, args);
    }

}
