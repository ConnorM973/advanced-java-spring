package com.codingnomads.springdata.example.ddl.manytomany.bidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column
    private int totalPages;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Author> authors;
}
