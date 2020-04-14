package com.af.learn.idea.spring.democrud.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author anna
 * @create 2019-12-09 15:17
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===================>servlet init....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("===================>servlet destroy....");
    }
}
