package com.posco.mes3.m00.material.query.listen;

import com.posco.mes3.m00.material.event.MaterialEvent;
import com.posco.mes3.m00.material.query.lifecycle.StoreLifecycle;
import com.posco.mes3.m00.material.query.model.FlatMaterial;
import com.posco.mes3.m00.material.query.store.MaterialFlatStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(MaterialEventSink.class)
public class MaterialEventConsumer {
    //
    private final MaterialFlatStore materialFlatStore;

    public MaterialEventConsumer(StoreLifecycle storeLifecycle) {
        //
        this.materialFlatStore = storeLifecycle.requestMaterialFlatStore();
    }

    //
    @StreamListener(MaterialEventSink.MATERIAL_INPUT)
    public void listenMaterialEvent(@Payload MaterialEvent materialEvent) {
        //
        System.out.println(String.format("MaterialEventConsumer.listenMaterialEvent - materialId: %s", materialEvent.getMaterial().getId()));
        materialFlatStore.create(new FlatMaterial(materialEvent.getMaterial()));
    }
}