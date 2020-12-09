package com.joycastle.model;

import lombok.Data;

/**
 * 用户实体
 *
 * @author  wencai.xu
 * @date  2020/12/8,0008
 * @version  V1.0
 **/
@Data
public class User {
    /**
     * 用户真实姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
