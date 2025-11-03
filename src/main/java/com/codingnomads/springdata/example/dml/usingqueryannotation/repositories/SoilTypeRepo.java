/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation.repositories;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {
    @Query("SELECT soilType FROM SoilType soilType WHERE soilType.id=1")
    SoilType getSoilTypeWithID1JPQL();

    @Query("SELECT soilType FROM SoilType soilType WHERE soilType.id=2")
    SoilType getSoilTypeWithID2JPQL();

    @Query("SELECT soilType FROM SoilType soilType WHERE soilType.id=3")
    SoilType getSoilTypeWithID3JPQL();

    @Query("SELECT soilType FROM SoilType soilType WHERE soilType.name=tester")
    SoilType getSoilTypeWithNameTesterJPQL();

    @Query("SELECT soilType FROM SoilType soilType WHERE soilType.name=tester2")
    SoilType getSoilTypeWithNameTester2JPQL();



}
