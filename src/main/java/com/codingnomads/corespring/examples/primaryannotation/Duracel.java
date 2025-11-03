package com.codingnomads.corespring.examples.primaryannotation;

import com.codingnomads.corespring.examples.autowiredannotation.Battery;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("duracel")
@Primary
@ToString
public class Duracel implements Battery {
}
