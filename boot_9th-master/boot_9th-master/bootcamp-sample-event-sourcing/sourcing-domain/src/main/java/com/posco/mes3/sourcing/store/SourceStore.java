package com.posco.mes3.sourcing.store;

import com.posco.mes3.shared.event.SourcingEvent;

import java.util.List;

public interface SourceStore {
    //
    public abstract void createSource(SourcingEvent sourcingEvent);
    public abstract List<SourcingEvent> retrieveSourcesById(String entityName, String id);
}
