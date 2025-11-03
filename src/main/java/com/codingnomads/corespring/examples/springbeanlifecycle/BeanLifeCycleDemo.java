/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeanlifecycle;

import com.codingnomads.corespring.examples.beanscopes.prototype.ExampleBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanLifeCycleConfig.class);
        ctx.refresh();
        final SpringBean springBean = ctx.getBean(SpringBean.class);
        final SpringBeanExample exampleBean= ctx.getBean(SpringBeanExample.class);
        ctx.close();
    }
}
