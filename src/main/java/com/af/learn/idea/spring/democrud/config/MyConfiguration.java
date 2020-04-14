package com.af.learn.idea.spring.democrud.config;


import com.af.learn.idea.spring.democrud.filter.MyFilter;
import com.af.learn.idea.spring.democrud.listener.MyListener;
import com.af.learn.idea.spring.democrud.servlet.MyServlet;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;

/**
 * @author anna
 * @create 2019-12-01 18:50
 */
@Configuration
//@EnableWebMvc
public class MyConfiguration implements WebMvcConfigurer{
//        implements WebMvcConfigurer {

//    @Bean
//    public  LoginInterceptor LoginInterceptor(){
//        return new LoginInterceptor();
//    }

    @Bean
    public  MyDefaultErrorAttributes errorAttributes(){
        return  new MyDefaultErrorAttributes();
    }

    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean ServletRegistrationBean(){
        ServletRegistrationBean bean  = new  ServletRegistrationBean(new MyServlet(),"/myservlet");
        return  bean;
    }

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean FilterRegistrationBean(){
        FilterRegistrationBean bean = new  FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/myservlet"));
        return  bean;
    }

    /***
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean ServletListenerRegistrationBean(){
        ServletListenerRegistrationBean listenerBean = new ServletListenerRegistrationBean();
        listenerBean.setListener(new MyListener());
        return listenerBean;
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer = new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>(){
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(9999);
            }
        };

        return webServerFactoryCustomizer;
    }

    @Bean
    public  WebMvcConfigurer WebMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new  WebMvcConfigurer(){
            @Autowired
           private LoginInterceptor LoginInterceptor;
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/text").setViewName("login");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                WebMvcConfigurer.super.addResourceHandlers(registry);
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(LoginInterceptor).addPathPatterns("/**").excludePathPatterns(
//                        "/index.html",
//                        "/",
//                        "/login",
//                        "/static/**"
//                );

            }
        };

        return adapter;
    }

    @Bean
    public  LocaleResolver  localeResolver(){
        return new MyLocalResolver();
    }


}
