package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("duracel")
@ToString
public class Duracel implements Battery {
}
