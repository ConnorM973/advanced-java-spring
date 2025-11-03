package com.codingnomads.springdata.example.ddl.manytomany.unidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable= false, updatable = false)
    private String name;

    @Column(nullable= false)
    private int age;



}
