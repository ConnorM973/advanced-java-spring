package com.codingnomads.ioc.lab.initial;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CodingNomadDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CodingNomadConfiguration.class);
        CodingNomad codingNomad = ctx.getBean(CodingNomad.class);
        System.out.println(codingNomad.createAwesomeSoftware());
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(CodingNomadDemo.class, args);

        printTree("codingNomad", 0, configurableApplicationContext.getBeanFactory());

    }
        private static void printTree(String bean, int level, ConfigurableListableBeanFactory beanFactory) {
            String prefix = "";
            if (level > 0) {
                prefix = "  |".repeat(level);
            }

            System.out.printf(
                    "%-40s required by: %-30s, requires: %-30s bean: %s\n",
                    prefix + " -> " + bean,
                    Arrays.toString(beanFactory.getDependentBeans(bean)),
                    Arrays.toString(beanFactory.getDependenciesForBean(bean)),
                    beanFactory.getBean(bean)
            );

            String[] dependenciesForBean = beanFactory.getDependenciesForBean(bean);
            for (String dependency : dependenciesForBean) {
                printTree(dependency, level + 1, beanFactory);
            }
        }
}
