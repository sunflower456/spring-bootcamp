package com.posco.mes3.quality.tracking.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TrackingStream.class)
public class TrackingEventSampleProducer {
    //
    @Autowired
    private TrackingStream trackingStream;

    //
    @Scheduled(fixedRate = 3000)
    public void produceSampleEvent() {
        //
        TrackingEvent event = TrackingEvent.sample();

        trackingStream.trackingInput()
                .send(MessageBuilder.withPayload(event).build());

    }
}
