package com.posco.mes3.m00.material.bind;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourcingEventSource {
    //
    String SOURING_EVENT_OUTPUT = "souringOutput";

    //
    @Output(SOURING_EVENT_OUTPUT)
    MessageChannel souringOutput();

}
