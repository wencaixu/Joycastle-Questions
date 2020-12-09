package com.joycastle.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应类
 *
 * @author wencai.xu
 * @version V1.0
 * @date 2020/12/8,0008
 * @see StatusCode
 **/

@Data
public class Response<T> implements Serializable {
    /**
     * 状态码
     */
    private int status;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    private Response(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private static <T> Response<T> creativeResponse(StatusCode statusCode, T data) {
        return new Response<>(statusCode.status, statusCode.msg, data);
    }

    public static <T> Response<T> success() {
        return creativeResponse(StatusCode.SUCCESS, null);
    }

    public static <T> Response<T> error() {
        return creativeResponse(StatusCode.ERROR, null);
    }

    public static <T> Response<T> success(T data) {
        return creativeResponse(StatusCode.SUCCESS, data);
    }

    public static <T> Response<T> error(T data) {
        return creativeResponse(StatusCode.ERROR, data);
    }
}

