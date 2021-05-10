package com.posco.mes3.m00.material.lifecycle;

import com.posco.mes3.m00.material.proxy.EventSourcingProducer;
import com.posco.mes3.m00.material.proxy.MaterialEventProducer;

public interface ProxyLifecycle {
    //
    public abstract MaterialEventProducer requestMaterialEventProducer();
    public abstract EventSourcingProducer requestEventSourcingProducer();
}
