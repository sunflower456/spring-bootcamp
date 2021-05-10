package com.posco.mes3.sourcing.listen;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SourcingEventSink {
    //
    String SOURING_EVENT_INPUT = "souringInput";

    @Input(SOURING_EVENT_INPUT)
    SubscribableChannel souringInput();

}
