package org.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyCache myCache;

    @GetMapping("/test")
    public String test() {
        return myCache.getValue();
    }

    @DeleteMapping("/test")
    public void evict() {
        myCache.evict();
    }
}
