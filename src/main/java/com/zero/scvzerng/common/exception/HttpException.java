package com.zero.scvzerng.common.exception;

/**
 * description
 * <p>
 * 2017-12-27 11:29
 *
 * @author scvzerng
 **/
public class HttpException extends AbstractException {

    public HttpException(int code, String message, Throwable e) {
        super(code, message, e);
    }
}
