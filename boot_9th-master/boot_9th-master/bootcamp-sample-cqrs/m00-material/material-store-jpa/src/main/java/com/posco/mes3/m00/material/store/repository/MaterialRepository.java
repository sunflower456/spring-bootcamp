package com.posco.mes3.m00.material.store.repository;

import com.posco.mes3.m00.material.store.jpo.MaterialJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialJpo, String> {
}
