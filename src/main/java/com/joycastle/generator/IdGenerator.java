package com.joycastle.generator;

/**
 * Id创建接口
 *
 * @author wencai.xu
 * @date 2020/12/8,0008
 * @version V1.0
 **/
public interface IdGenerator {

    /**
     * 用户id创建
     *
     * @param increment
     *     自增id(传入时间戳更为合适)
     * @return
     *     用户随机id
     */
    long create(long increment);
}
