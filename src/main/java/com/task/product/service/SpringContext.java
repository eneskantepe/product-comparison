package com.task.product.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @author Enes Kantepe
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    public static Object getBeanOfName(String name) {
        if (context != null) {
            return context.getBean(name);
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContext.context = context;
    }
}