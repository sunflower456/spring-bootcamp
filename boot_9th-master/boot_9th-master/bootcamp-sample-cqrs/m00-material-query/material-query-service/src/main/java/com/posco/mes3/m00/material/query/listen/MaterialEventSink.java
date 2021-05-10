package com.posco.mes3.m00.material.query.listen;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MaterialEventSink {
    //
    String MATERIAL_INPUT = "materialInput";

    @Input(MATERIAL_INPUT)
    SubscribableChannel materialInput();


}
