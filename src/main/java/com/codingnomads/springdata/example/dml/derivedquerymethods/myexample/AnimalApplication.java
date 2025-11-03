package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codingnomads.springdata.example.dml.derivedquerymethods.codewarriorexample.CodeWarriorApplication;
import com.codingnomads.springdata.example.dml.derivedquerymethods.plantexample.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AnimalApplication implements CommandLineRunner{

    @Autowired
    AnimalRepo animalRepo;

    @Autowired
    LocationRepo locationRepo;

    public static void main(String[] args) {SpringApplication.run(AnimalApplication.class);
}
    @Transactional
    public void run(String... args) throws Exception {
        Location hartford= Location.builder().country("USA").state("Connecticut").town("Hartford").build();
        Location juneau= Location.builder().country("USA").state("Alaska").town("Juneau").build();
        Location honolulu= Location.builder().country("USA").state("Hawaii").town("Honolulu").build();

      //  hartford=locationRepo.save(hartford);
        //juneau=locationRepo.save(juneau);
        //honolulu=locationRepo.save(honolulu);

        ArrayList<Location> allLocations= new ArrayList<>();
        allLocations.add(hartford);
        allLocations.add(juneau);
        allLocations.add(honolulu);

        ArrayList<Location> justJuneau= new ArrayList<>();
        justJuneau.add(juneau);

        ArrayList<Location> justHonolulu= new ArrayList<>();
        justHonolulu.add(honolulu);

        Animal deer= Animal.builder().name("deer").hasFur(true).locations(allLocations).build();
        Animal seaTurtle= Animal.builder().name("sea turtle").hasFur(false).locations(justHonolulu).build();
        Animal grizzlyBear= Animal.builder().name("grizzly bear").hasFur(true).locations(justJuneau).build();

        animalRepo.save(deer);
        animalRepo.save(seaTurtle);
        animalRepo.save(grizzlyBear);



        System.out.println("\n********* findByName() *********");
        Animal animal1 = animalRepo.findByName("grizzly bear");
        System.out.println(animal1);

        System.out.println("\n********* findByHasFurIsTrue() *********");
        List<Animal> animals= animalRepo.findByHasFurIsTrue();
        animals.forEach(System.out::println);

        System.out.println("\n********* findByLocation() *********");
        List<Animal> animals2= animalRepo.findByLocations(honolulu);
        animals2.forEach(System.out::println);
    }
}
