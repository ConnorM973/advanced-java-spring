package com.codingnomads.springweb.resttemplate.POST.postForLocation;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class User {
    Info info;
    Error error;
    String status;
    }
