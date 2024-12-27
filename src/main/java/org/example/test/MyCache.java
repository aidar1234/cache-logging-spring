package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCache {

    @Cacheable(value = "my_cache")
    public String getValue() {
        log.info("VALUE FROM DB");
        return "Hello World";
    }

    @CacheEvict(value = "my_cache")
    public void evict() {
        log.info("EVICTED");
    }
}
