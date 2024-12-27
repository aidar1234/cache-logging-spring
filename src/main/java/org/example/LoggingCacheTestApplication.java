package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LoggingCacheTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingCacheTestApplication.class, args);
    }

}
