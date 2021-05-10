package com.posco.mes3.m00.material.lifecycle;

import com.posco.mes3.m00.material.proxy.EventSourcingProducer;
import com.posco.mes3.m00.material.proxy.MaterialEventProducer;
import org.springframework.stereotype.Component;

@Component
public class ProxyLifecycler implements ProxyLifecycle {
    //
    private final MaterialEventProducer materialEventProducer;
    private final EventSourcingProducer eventSourcingProducer;

    public ProxyLifecycler(MaterialEventProducer materialEventProducer, EventSourcingProducer eventSourcingProducer) {
        //
        this.materialEventProducer = materialEventProducer;
        this.eventSourcingProducer = eventSourcingProducer;
    }

    public MaterialEventProducer requestMaterialEventProducer() {
        //
        return materialEventProducer;
    }

    public EventSourcingProducer requestEventSourcingProducer() {
        //
        return eventSourcingProducer;
    }
}
