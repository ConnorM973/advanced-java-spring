package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classrooms")
@NoArgsConstructor
@Getter
@Setter

public class Classroom {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String subject;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="school_id", referencedColumnName = "id"),
            @JoinColumn(name="location",referencedColumnName = "location")
    })
    private School school;

}
