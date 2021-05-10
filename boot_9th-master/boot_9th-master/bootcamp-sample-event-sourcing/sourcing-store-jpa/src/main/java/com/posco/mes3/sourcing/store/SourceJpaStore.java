package com.posco.mes3.sourcing.store;

import com.posco.mes3.shared.event.SourcingEvent;
import com.posco.mes3.sourcing.entity.Source;
import com.posco.mes3.sourcing.store.jpo.SourceJpo;
import com.posco.mes3.sourcing.store.repository.SourceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SourceJpaStore implements SourceStore {
    //
    private final SourceRepository sourceRepository;

    public SourceJpaStore(SourceRepository sourceRepository) {
        //
        this.sourceRepository = sourceRepository;
    }

    @Override
    public void createSource(SourcingEvent sourcingEvent) {
        //
        sourceRepository.save(new SourceJpo(sourcingEvent));
    }

    @Override
    public List<SourcingEvent> retrieveSourcesById(String entityName, String id) {
        //
        //List<SourceJpo> sourceJpos = sourceRepository.findAllByEntityNameAndIdOrderByTimeDesc(entityName, id);
        List<SourceJpo> sourceJpos = sourceRepository.findAll();
        return sourceJpos.stream()
                .map(SourceJpo::toDomain)
                .collect(Collectors.toList());
    }
}
