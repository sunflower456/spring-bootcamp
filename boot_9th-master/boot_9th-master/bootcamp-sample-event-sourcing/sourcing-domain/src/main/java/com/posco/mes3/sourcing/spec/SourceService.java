package com.posco.mes3.sourcing.spec;

import com.posco.mes3.shared.event.SourcingEvent;

import java.util.List;

public interface SourceService {
    //
    public abstract void registerSource(SourcingEvent sourcingEvent);
    public abstract List<SourcingEvent> retrieveSource(String entityName, String id);
}
