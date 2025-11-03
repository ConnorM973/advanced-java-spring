package com.codingnomads.springdata.example.ddl.manytomany.jointableexample;

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
    @JoinTable(
            name="book_authors",
            joinColumns= @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors;
}

