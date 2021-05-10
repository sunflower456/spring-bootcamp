package com.posco.mes3.m00.material.bind;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MaterialEventSource {
    //
    String MATERIAL_OUTPUT = "materialOutput";

    //
    @Output(MATERIAL_OUTPUT)
    MessageChannel materialOutput();

}
