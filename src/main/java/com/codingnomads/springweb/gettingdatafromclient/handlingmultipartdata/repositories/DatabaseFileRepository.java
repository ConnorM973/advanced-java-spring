/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.repositories;

import com.codingnomads.springdata.lab_complete.models.Route;
import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {

    Optional<DatabaseFile> findAllByFileNameContaining(String fileName);
}
