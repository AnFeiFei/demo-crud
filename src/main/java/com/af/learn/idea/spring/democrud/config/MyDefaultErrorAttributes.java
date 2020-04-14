package com.af.learn.idea.spring.democrud.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author anna
 * @create 2019-12-09 14:05
 */
public class MyDefaultErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
         Map<String, Object>  map= super.getErrorAttributes(webRequest, includeStackTrace);
         map.put("ext",String.valueOf(webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST)));
        return map;
    }
}
