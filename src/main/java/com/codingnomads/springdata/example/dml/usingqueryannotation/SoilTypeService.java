package com.codingnomads.springdata.example.dml.usingqueryannotation;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.Plant;
import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import com.codingnomads.springdata.example.dml.usingqueryannotation.repositories.PlantRepo;
import java.util.List;

import com.codingnomads.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSOutput;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    public void saveStuff(){
        if (soilTypeRepo.findAll().isEmpty()){
            SoilType soilType= SoilType.builder().dry(true).ph(7.6).name("tester").build();
            SoilType soilType2= SoilType.builder().dry(false).ph(7.2).name("tester2").build();

            soilTypeRepo.save(soilType);
            soilTypeRepo.save(soilType2);
        }
    }

    public void returnID1Soil(SoilTypeRepo soilTypeRepo) {
        SoilType example = soilTypeRepo.getSoilTypeWithID1JPQL();
        System.out.println(example.toString());
    }
}
