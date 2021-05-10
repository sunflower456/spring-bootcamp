package com.posco.mes3.m00.material.proxy;

import com.posco.mes3.shared.event.SourcingEvent;

public interface EventSourcingProducer {
    //
    public abstract void produceEventSourcing(SourcingEvent sourcingEvent);
}
