package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("energizer")
@ToString
public class Energizer implements Battery {
}
