package com.codingnomads.corespring.examples.primaryannotation;
import com.codingnomads.corespring.examples.autowiredannotation.Battery;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("energizer")
@ToString
public class Energizer implements Battery {
}
