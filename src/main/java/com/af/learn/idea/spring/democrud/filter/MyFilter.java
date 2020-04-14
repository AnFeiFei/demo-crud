package com.af.learn.idea.spring.democrud.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author anna
 * @create 2019-12-09 15:01
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==========>myfilter......");
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
