package com.urttom.memory.xtpz.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错了!";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", HttpStatus.UNAUTHORIZED.value());
        jsonObject.put("msg", msg);
        return jsonObject;
    }
}
