package com.posco.mes3.quality.tracking.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(TrackingStream.class)
public class TrackingCountReducer {
    //
    private int totalCount = 0;

    @Transformer(inputChannel = TrackingStream.TRACKING_INPUT, outputChannel = TrackingStream.TRACKING_COUNT_OUTPUT)
    public TotalTrackingCount reduce(@Payload TrackingEvent trackingEvent) {
        //
        if (totalCount > 100) {
            totalCount = 0;
        }

        totalCount += trackingEvent.getAbnormalCount();
        System.out.println("=========================================================");
        System.out.println(String.format("TrackingProcessor.reduce(): %d", totalCount));
        return new TotalTrackingCount(totalCount);
    }
}
