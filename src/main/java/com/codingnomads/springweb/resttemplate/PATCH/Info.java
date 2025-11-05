package com.codingnomads.springweb.resttemplate.PATCH;

import lombok.Builder;
import lombok.Data;

@Data

public class Info {
    private long id;
    private String email;
    private String first_name;
    private String last_name;
    private long createdAt;
    private long updatedAt;

    public Info() {

    }
}
