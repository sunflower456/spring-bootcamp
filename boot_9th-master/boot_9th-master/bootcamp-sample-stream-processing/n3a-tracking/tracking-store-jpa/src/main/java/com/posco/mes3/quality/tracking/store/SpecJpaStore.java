package com.posco.mes3.quality.tracking.store;

import com.posco.mes3.quality.tracking.domain.entity.AnomalySpec;
import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;
import com.posco.mes3.quality.tracking.domain.store.SpecStore;
import com.posco.mes3.quality.tracking.store.jpo.SingleSpecJpo;
import com.posco.mes3.quality.tracking.store.repository.SingleSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SpecJpaStore implements SpecStore {
    //
    private final SingleSpecRepository singleSpecRepository;

    public SpecJpaStore(SingleSpecRepository singleSpecRepository) {
        //
        this.singleSpecRepository = singleSpecRepository;
    }

    @Override
    public void createSingleSpec(SingleSpec singleSpec) {
        //
        singleSpecRepository.save(new SingleSpecJpo(singleSpec));
    }

    @Override
    public SingleSpec retrieveSingleSpec(String specId) {
        //
        Optional<SingleSpecJpo> singleSpecJpo = singleSpecRepository.findById(specId);
        if (!singleSpecJpo.isPresent()) {
            throw new NoSuchElementException(String.format("SingeSpec(%s) is not found.", specId));
        }

        return singleSpecJpo.get().toDomain();
    }

    @Override
    public List<AnomalySpec> retrieveAllSingleSpecs() {
        //
        List<SingleSpecJpo> singleSpecJpos = singleSpecRepository.findAll();
        return singleSpecJpos.stream()
                .map(SingleSpecJpo::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void updateSingleSpec(SingleSpec singleSpec) {
        //
        singleSpecRepository.save(new SingleSpecJpo(singleSpec));
    }

    @Override
    public void deleteSingleSpec(SingleSpec singleSpec) {
        //
        singleSpecRepository.delete(new SingleSpecJpo(singleSpec));
    }

    @Override
    public boolean exists(String specId) {
        //
        return singleSpecRepository.existsById(specId);
    }
}
