package com.posco.mes3.quality.tracking.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TrackingStream {
    //
    String TRACKING_OUTPUT = "trackingOutput";

    @Output(TRACKING_OUTPUT)
    MessageChannel trackingOutput();

    //
    String TRACKING_INPUT = "trackingInput";

    @Input(TRACKING_INPUT)
    SubscribableChannel trackingInput();

    //
    String TRACKING_COUNT_OUTPUT = "trackingCountOutput";

    @Output(TRACKING_COUNT_OUTPUT)
    MessageChannel trackingCountOutput();

    //
    String TRACKING_COUNT_INPUT = "trackingCountInput";

    @Input(TRACKING_COUNT_INPUT)
    SubscribableChannel trackingCountInput();
}
