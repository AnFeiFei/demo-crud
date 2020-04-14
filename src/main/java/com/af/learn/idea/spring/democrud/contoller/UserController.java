package com.af.learn.idea.spring.democrud.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author anna
 * @create 2019-12-02 17:07
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(@RequestParam(value="userName") String userName, @RequestParam(value="password") String password, Model model, HttpSession session){

        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            model.addAttribute("errorMsg","请输入用户名");
            return "login";
        }

        if( StringUtils.isEmpty(password)){
            model.addAttribute("errorMsg","请输入密码");
            return "login";
        }

        if(!password.equals("111111")){
            model.addAttribute("errorMsg","密码错误");
            return "login";
        }

        session.setAttribute("userName",userName);
        return "redirect:/dashboard";
    }


    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
