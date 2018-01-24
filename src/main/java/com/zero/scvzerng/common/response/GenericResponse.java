package com.zero.scvzerng.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description
 * <p>
 * 2017-12-27 09:25
 *
 * @author scvzerng
 **/
@Data
public class GenericResponse<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 调用消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 异常堆栈信息
     */
    private String stackInfo;
    /**
     * 服务提供方返回的本次调用ID
     */
    private String tradeId;
    /**
     * 参数校验失败时返回的详细信息
     */
    private List<FieldError> details;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FieldError{
        /**
         * 字段名
         */
        private String field;
        /**
         * 校验消息
         */
        private String message;
        /**
         * 传入的值
         */
        private Object value;
    }
}
