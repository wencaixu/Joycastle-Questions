package com.joycastle.generator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class UIdGenTest {
    // 42949672960
    // 4294967296
    // 47244640256
    @Test
    void create() {
        Map<Long,Integer> map = new HashMap<>();
        for(int i = 0; i < 10000000; i++){
            long l = new UIdGen().create(i);
            if(map.containsKey(l)){
                map.put(l,map.get(l)+1);
            }else{
                map.put(l,1);
            }
        }
        for(Map.Entry<Long, Integer> maps : map.entrySet()){
             System.out.println(maps.getKey()+":"+maps.getValue());
        }
    }
}