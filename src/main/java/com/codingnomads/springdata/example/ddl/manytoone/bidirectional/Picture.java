package com.codingnomads.springdata.example.ddl.manytoone.bidirectional;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;
import org.apache.ibatis.annotations.Many;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Picture {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, updatable = false)
    private long fileSize;

    @ManyToOne(cascade= CascadeType.ALL, optional = false)
    private Post post;

}
