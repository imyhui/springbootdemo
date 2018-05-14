package com.hui.handle;

import com.hui.domain.Result;
import com.hui.exception.GirlException;
import com.hui.utils.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by yz on 18/5/13.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
