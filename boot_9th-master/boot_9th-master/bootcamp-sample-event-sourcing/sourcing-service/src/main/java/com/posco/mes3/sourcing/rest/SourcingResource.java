package com.posco.mes3.sourcing.rest;

import com.posco.mes3.shared.event.SourcingEvent;
import com.posco.mes3.sourcing.lifecycle.ServiceLifecycle;
import com.posco.mes3.sourcing.spec.SourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SourcingResource implements SourceService {
    //
    private final SourceService sourceService;

    public SourcingResource(ServiceLifecycle serviceLifecycle) {
        //
        this.sourceService = serviceLifecycle.requestSourceService();
    }

    @Override
    public void registerSource(SourcingEvent sourcingEvent) {
    }

    @Override
    @GetMapping(value = "/{entityName}/{id}")
    public List<SourcingEvent> retrieveSource(@PathVariable(value = "entityName") String entityName, @PathVariable(value = "id") String id) {
        //
        return sourceService.retrieveSource(entityName, id);
    }
}
