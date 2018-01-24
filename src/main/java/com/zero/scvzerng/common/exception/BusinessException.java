package com.zero.scvzerng.common.exception;

public class BusinessException extends AbstractException {
    private String tradeId;
    private String stackInfo;
    public BusinessException(int code, String message, Throwable e) {
        super(code, message, e);
    }

    public BusinessException( String message, Throwable e) {
        this(2000,message,e);
    }

    public BusinessException(String message) {
       this(2000,message,null);
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getStackInfo() {
        return stackInfo;
    }

    public void setStackInfo(String stackInfo) {
        this.stackInfo = stackInfo;
    }
}
