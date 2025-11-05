package com.codingnomads.springweb.resttemplate.PUT;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class User {
    private Info data;
    private Error error;
    private String status;


}
