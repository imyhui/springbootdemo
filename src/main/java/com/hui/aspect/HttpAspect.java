package com.hui.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by yz on 18/5/10.
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 可先写方法再写注解，有自动补全
     */
    @Before("execution(public * com.hui.controller.GirlController.girlList(..))")
    public void log() {
        System.out.println("拦截");
    }
}
