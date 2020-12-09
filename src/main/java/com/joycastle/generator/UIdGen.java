package com.joycastle.generator;

import org.springframework.stereotype.Component;

/**
 * 用户唯一id生成
 *
 * @author  wencai.xu
 * @date 2020/12/8,0008
 * @version V1.0
 **/
@Component
public class UIdGen implements IdGenerator{

    @Override
    public long create(long increment){
        long l1,l2,r1,r2,loop = 3;
        l1 = (increment >> 32) & 4294967295L;
        r1 = (increment & 4294967295L);
        int i = 0;
        while(i < loop){
            l2 = r1;
            r2 = l1;
            l1 = l2;
            r1 = r2;
            i = i + 1;
        }
        return l1 << 32 + r1;
    }
}
