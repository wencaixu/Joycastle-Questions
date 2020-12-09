package com.joycastle.model;

/**
 * 状态枚举
 *
 * @author wencai.xu
 * @version V1.0
 * @date 2020/12/8,0008
 * @see Response
 **/
public enum StatusCode {
    /**
     * 系统错误
     */
    SERVER_ERROR(500, "系统错误")
    ,
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功")
    ,
    /**
     * 操作失败
     */
    ERROR(444,"操作失败")
    ;

    int status;
    String msg;

    StatusCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static String of(int code) {
        for (StatusCode statusCode : StatusCode.values()) {
            if (statusCode.status == code) {
                return statusCode.msg;
            }
        }
        return null;
    }
}
