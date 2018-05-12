package com.hui.utils;


import com.hui.domain.Result;

/**
 * Created by yz on 18/5/13.
 */
public class ResultUtil {

    public static Result success(Object object)  {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success()
    {
        return success(null);
    }

    public static Result error(Integer code, String msg)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
