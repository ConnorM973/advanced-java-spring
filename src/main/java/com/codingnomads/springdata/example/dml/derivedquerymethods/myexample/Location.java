package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import lombok.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Location {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String town;

    @ManyToMany(mappedBy="locations",cascade=CascadeType.ALL)
    private List<Animal> animal;


}
