package com.codingnomads.corespring.examples.springbeanlifecycle;

import java.util.Arrays;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanExample implements BeanNameAware {
    @Override
    public void setBeanName(@NonNull String name) {
        System.out.println("I am a Spring Bean name example: ".concat(name));
    }
}
