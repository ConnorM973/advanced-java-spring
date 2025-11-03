package com.codingnomads.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "application-test.properties", ignoreResourceNotFound = true)
//@Value(value = "${application-test.properties}")
public class Example {
    public Example() {
        System.out.println("Example is now ready.");
    }
}
