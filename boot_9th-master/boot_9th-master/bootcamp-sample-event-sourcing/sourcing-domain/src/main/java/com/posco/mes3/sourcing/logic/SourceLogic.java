package com.posco.mes3.sourcing.logic;

import com.posco.mes3.shared.event.SourcingEvent;
import com.posco.mes3.sourcing.entity.Source;
import com.posco.mes3.sourcing.lifecycle.StoreLifecycle;
import com.posco.mes3.sourcing.spec.SourceService;
import com.posco.mes3.sourcing.store.SourceStore;

import java.util.List;

public class SourceLogic implements SourceService {
    //
    private final SourceStore sourceStore;

    public SourceLogic(StoreLifecycle storeLifecycle) {
        //
        this.sourceStore = storeLifecycle.requestSourceStore();
    }

    @Override
    public void registerSource(SourcingEvent sourcingEvent) {
        //
        sourceStore.createSource(sourcingEvent);
    }

    @Override
    public List<SourcingEvent> retrieveSource(String entityName, String id) {
        //
        return sourceStore.retrieveSourcesById(entityName, id);
    }
}
