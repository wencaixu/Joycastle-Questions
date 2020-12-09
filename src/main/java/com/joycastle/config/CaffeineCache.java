package com.joycastle.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * CaffeineCache缓存（仅仅为了好验收，仅此而已）
 *
 * @author wencai.xu
 * @date  2020/12/8,0008
 * @version  V1.0
 **/

public class CaffeineCache {

    public static LoadingCache<String,String> LOADING_CACHE = Caffeine.newBuilder()
            .maximumSize(10000)
            // 写后10分钟过期(测试)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(key -> System.currentTimeMillis()+"");

}
