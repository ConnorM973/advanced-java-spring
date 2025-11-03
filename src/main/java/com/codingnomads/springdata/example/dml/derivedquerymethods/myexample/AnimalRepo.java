package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Long>{

    Animal findByName(String name);
    List<Animal> findByNameIsNot(String name);
    List<Animal> findByNameContaining (String letters);
    List<Animal> findByHasFurIsTrue();
    List<Animal> findByHasFurIsFalse();
    List<Animal> findByLocations (Location location);
    Animal findFirstByLocations_Country(String country);
    List<Animal> findFirst3ByLocations_Country(String country);
    List<Animal> findByNameStartingWith(String namePrefix);
    List<Animal> findByLocationsIsNot(Location location);

}
