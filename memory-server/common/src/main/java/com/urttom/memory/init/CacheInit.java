package com.urttom.memory.init;

import com.urttom.memory.cache.SysCodeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CacheInit implements ApplicationRunner {

    @Autowired
    private SysCodeCache sysCodeCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sysCodeCache.init();
    }
}
