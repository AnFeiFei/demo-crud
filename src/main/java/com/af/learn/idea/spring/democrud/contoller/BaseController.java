package com.af.learn.idea.spring.democrud.contoller;

import com.af.learn.idea.spring.democrud.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author anna
 * @create 2019-12-01 21:01
 */
@Controller
public class BaseController {

    @RequestMapping(value = {"/","/index.html"})
    public String index(){
        return "login";
    }

    @RequestMapping("testException")
    public void testException(){
        throw new MyException();
    }

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new MyException();
        }
        return "Hello World";
    }
}
