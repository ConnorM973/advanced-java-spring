package com.codingnomads.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class IntelliJ {
    @Autowired
    private JDK jdk;

    public IntelliJ() {
        System.out.println("IntelliJ is ready.");
    }
}
