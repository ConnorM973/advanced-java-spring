package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carkeys")
@NoArgsConstructor
@Getter
@Setter
public class CarKeys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String type;

    @OneToOne(optional = false)
    private Car car;

}
