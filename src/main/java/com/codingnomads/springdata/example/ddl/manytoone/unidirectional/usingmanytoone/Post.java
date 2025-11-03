/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import jakarta.persistence.*;
import lombok.*;
import org.apache.ibatis.annotations.Many;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name="author_id_example")
    private Author author;
}
