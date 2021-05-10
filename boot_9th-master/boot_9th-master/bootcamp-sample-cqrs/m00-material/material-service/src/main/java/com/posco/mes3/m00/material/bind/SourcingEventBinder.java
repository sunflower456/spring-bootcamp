package com.posco.mes3.m00.material.bind;

import com.posco.mes3.m00.material.proxy.EventSourcingProducer;
import com.posco.mes3.shared.event.SourcingEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(SourcingEventSource.class)
public class SourcingEventBinder implements EventSourcingProducer {
    //
    private final SourcingEventSource sourcingEventSource;

    public SourcingEventBinder(SourcingEventSource sourcingEventSource) {
        //
        this.sourcingEventSource = sourcingEventSource;
    }

    public void produceEventSourcing(SourcingEvent sourcingEvent) {
        //
        sourcingEventSource.souringOutput()
                .send(MessageBuilder.withPayload(sourcingEvent).build());
    }
}
