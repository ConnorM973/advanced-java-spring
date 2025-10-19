package com.codingnomads.ioc.examples.dependencylookup;

public class ExampleGreetingProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "Hello example!";
    }
}
