package org.example.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class MyLoggingCacheManager implements CacheManager {

    private final CacheManager delegate;

    @Override
    public Cache getCache(String name) {
        Cache cache = delegate.getCache(name);
        return cache == null ? null : new LoggingCacheWrapper(cache);
    }

    @Override
    public Collection<String> getCacheNames() {
        return delegate.getCacheNames();
    }

    // Название кэша в аннотации @Cacheable
    @RequiredArgsConstructor
    @Slf4j
    public static class LoggingCacheWrapper implements Cache {

        private final Cache delegate;

        @Override
        public String getName() {
            return delegate.getName();
        }

        @Override
        public Object getNativeCache() {
            return delegate.getNativeCache();
        }

        @Override
        public ValueWrapper get(Object key) {
            ValueWrapper valueWrapper = delegate.get(key);
            if (valueWrapper == null) {
                log.info("No cache found for key {}", key);
            } else {
                log.info("Found cache for key {}", key);
            }
            return valueWrapper;
        }

        @Override
        public <T> T get(Object key, Class<T> type) {
            T t = delegate.get(key, type);
            if (t == null) {
                log.info("No cache found for key {}", key);
            } else {
                log.info("Found cache for key {}", key);
            }
            return t;
        }

        @Override
        public <T> T get(Object key, Callable<T> valueLoader) {
            T t = delegate.get(key, valueLoader);
            if (t == null) {
                log.info("No cache found for key {}", key);
            } else {
                log.info("Found cache for key {}", key);
            }
            return t;
        }

        @Override
        public void put(Object key, Object value) {
            delegate.put(key, value);
        }

        @Override
        public void evict(Object key) {
            delegate.evict(key);
        }

        @Override
        public void clear() {
            delegate.clear();
        }
    }
}
