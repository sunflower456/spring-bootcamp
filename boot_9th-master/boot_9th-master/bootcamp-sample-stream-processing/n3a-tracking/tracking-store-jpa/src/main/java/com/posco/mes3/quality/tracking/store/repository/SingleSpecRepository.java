package com.posco.mes3.quality.tracking.store.repository;

import com.posco.mes3.quality.tracking.store.jpo.SingleSpecJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SingleSpecRepository extends JpaRepository<SingleSpecJpo, String> {
}
