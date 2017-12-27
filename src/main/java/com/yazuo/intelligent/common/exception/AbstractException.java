package com.yazuo.intelligent.common.exception;


public class AbstractException extends RuntimeException {
    private int code;

    public AbstractException(int code,String message,Throwable e){
        super(message,e);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
