package org.example.test;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCacheConfig {

    @Bean
    public CacheManager myCacheManager() {
        return new MyLoggingCacheManager(new ConcurrentMapCacheManager("my_cache"));
    }
}
