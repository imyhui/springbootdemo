package com.hui.exception;

import com.hui.enums.ResultEnum;

/**
 * Spring 对 RuntimeException  会发生事务回滚，Exception不会
 */
public class GirlException extends  RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
