package com.hui.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yz on 18/5/10.
 */
@Aspect
@Component
public class HttpAspect {

    //日志打印
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 可先写方法再写注解，有自动补全
     *定义切面代码复用
     */
    @Pointcut("execution(public * com.hui.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefor() {
        logger.info("拦截前");
    }

    @After("log()")
    public void doAfter() {
        logger.info("拦截后");
    }
}
