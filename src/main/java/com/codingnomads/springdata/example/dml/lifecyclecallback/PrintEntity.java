/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PrePersist
    public void printMessage1(){
        System.out.println("Printing Message 1");
    }
    @PreUpdate
    public void printMessage2(){
        System.out.println("Printing Message 2");
    }
    @PreRemove
    public void printMessage3(){
        System.out.println("Printing Message 3");
    }

}
