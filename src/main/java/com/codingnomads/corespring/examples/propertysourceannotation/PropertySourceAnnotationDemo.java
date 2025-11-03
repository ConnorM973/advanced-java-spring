/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.propertysourceannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final App app = ctx.getBean(App.class);
        System.out.println("Values from myapp.properties: " + "App Name: " + app.getAppName() + ", App Version: "
                + app.getAppVersion() + " App Example Name: " + app.getAppExampleName() + "App Example Version: " +app.getAppExampleVersion());
        ctx.close();
    }
}
