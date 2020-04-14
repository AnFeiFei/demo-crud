package com.af.learn.idea.spring.democrud.contoller;

import com.af.learn.idea.spring.democrud.exception.MyException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anna
 * @create 2019-12-06 11:35
 */
@ControllerAdvice
//@Component
public class ExceptionHandlerMain {

    @ExceptionHandler(MyException.class)
    public String ExceptionHandlerFunction(HttpServletRequest httpRequest, Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("asss","nnn");

        httpRequest.setAttribute("javax.servlet.error.status_code",500);
        httpRequest.setAttribute("ext",map);
//        return map;
        return "forward:/error";
    }


}
