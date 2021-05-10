package com.posco.mes3.sourcing.listen;

import com.posco.mes3.shared.event.SourcingEvent;
import com.posco.mes3.sourcing.lifecycle.ServiceLifecycle;
import com.posco.mes3.sourcing.spec.SourceService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(SourcingEventSink.class)
public class SourcingEventConsumer {
    //
    private final SourceService sourceService;

    public SourcingEventConsumer(ServiceLifecycle serviceLifecycle) {
        //
        this.sourceService = serviceLifecycle.requestSourceService();
    }

    //
    @StreamListener(SourcingEventSink.SOURING_EVENT_INPUT)
    public void listenSourcingEvent(@Payload SourcingEvent sourcingEvent) {
        //
        System.out.println(String.format("SourcingEventConsumer.listenSourcingEvent - id: %s", sourcingEvent.getId()));
        sourceService.registerSource(sourcingEvent);
    }
}