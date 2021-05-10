package com.posco.mes3.m00.material.bind;

import com.posco.mes3.m00.material.event.MaterialEvent;
import com.posco.mes3.m00.material.proxy.MaterialEventProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(MaterialEventSource.class)
public class MaterialEventBinder implements MaterialEventProducer {
    //
    private final MaterialEventSource materialEventSource;

    public MaterialEventBinder(MaterialEventSource materialEventSource) {
        //
        this.materialEventSource = materialEventSource;
    }

    public void produceMaterialEvent(MaterialEvent materialEvent) {
        //
        materialEventSource.materialOutput()
                .send(MessageBuilder.withPayload(materialEvent).build());
    }
}
