package com.posco.mes3.sourcing.store.repository;

import com.posco.mes3.sourcing.store.jpo.SourceJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SourceRepository extends JpaRepository<SourceJpo, String> {
    //
    List<SourceJpo> findAllByEntityNameAndIdOrderByTimeDesc(String entityName, String id);
}
