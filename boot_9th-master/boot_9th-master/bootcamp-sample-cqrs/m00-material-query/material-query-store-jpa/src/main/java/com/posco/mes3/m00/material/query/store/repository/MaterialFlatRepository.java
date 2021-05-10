package com.posco.mes3.m00.material.query.store.repository;

import com.posco.mes3.m00.material.query.store.jpo.MaterialFlatJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialFlatRepository extends JpaRepository<MaterialFlatJpo, String> {
}
