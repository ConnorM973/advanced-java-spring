package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schools")
@NoArgsConstructor
@Getter
@Setter

public class School {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String location;

}
