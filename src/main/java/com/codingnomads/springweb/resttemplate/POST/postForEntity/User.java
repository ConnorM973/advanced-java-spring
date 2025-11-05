package com.codingnomads.springweb.resttemplate.POST.postForEntity;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class User {
    Info info;
    Error error;
    String status;


}
