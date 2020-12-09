package com.joycastle.generator;

import org.springframework.stereotype.Component;

/**
 * 随机生成用户id优化
 *
 * @author  wencai.xu
 * @date  2020/12/8,0008
 * @version  V1.0
 **/
@Component
public class UIdGenOptimizer implements IdGenerator {
    @Override
    public long create(long increment) {
        return 0;
    }
}
