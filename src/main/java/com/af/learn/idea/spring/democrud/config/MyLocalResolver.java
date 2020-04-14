package com.af.learn.idea.spring.democrud.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author anna
 * @create 2019-12-02 16:43
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(request.getParameter("CHANGE_LOCALE"))){
            locale = new Locale(request.getParameter("CHANGE_LOCALE"));
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
