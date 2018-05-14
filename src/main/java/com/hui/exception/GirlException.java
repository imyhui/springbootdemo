package com.hui.exception;

/**
 * Spring 对 RuntimeException  会发生事务回滚，Exception不会
 */
public class GirlException extends  RuntimeException{

    private Integer code;

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
