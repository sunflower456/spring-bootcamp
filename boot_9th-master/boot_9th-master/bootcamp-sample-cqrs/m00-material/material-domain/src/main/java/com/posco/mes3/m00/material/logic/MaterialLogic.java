package com.posco.mes3.m00.material.logic;

import com.posco.mes3.m00.material.entity.Material;
import com.posco.mes3.m00.material.lifecycle.ProxyLifecycle;
import com.posco.mes3.m00.material.lifecycle.StoreLifecycle;
import com.posco.mes3.m00.material.proxy.EventSourcingProducer;
import com.posco.mes3.m00.material.proxy.MaterialEventProducer;
import com.posco.mes3.m00.material.store.MaterialStore;
import com.posco.mes3.m00.material.event.MaterialEvent;
import com.posco.mes3.m00.material.spec.MaterialService;
import com.posco.mes3.share.domain.NameValueList;
import com.posco.mes3.shared.event.SourcingEvent;

public class MaterialLogic implements MaterialService {
    //
    private final MaterialStore materialStore;
    private final MaterialEventProducer materialEventProducer;
    private final EventSourcingProducer eventSourcingProducer;

    public MaterialLogic(StoreLifecycle storeLifecycle, ProxyLifecycle proxyLifecycle) {
        //
        this.materialStore = storeLifecycle.requestMaterialStore();
        this.materialEventProducer = proxyLifecycle.requestMaterialEventProducer();
        this.eventSourcingProducer = proxyLifecycle.requestEventSourcingProducer();
    }

    public String registerMaterial(Material material) {
        //
        if (materialStore.existsById(material.getId())) {
            throw new RuntimeException(String.format("Material(%s) is already exists", material.getId()));
        }

        materialStore.create(material);
        materialEventProducer.produceMaterialEvent(MaterialEvent.buildCreateEvent(material));
        eventSourcingProducer.produceEventSourcing(SourcingEvent.buildCreateEvent("Shared", "Material", material.getNameValues()));

        return material.getId();
    }

    public Material findMaterialById(String id) {
        //
        return materialStore.retrieve(id);
    }

    @Override
    public void modifyMaterial(String id, NameValueList nameValues) {
        //
        Material material = materialStore.retrieve(id);
        NameValueList changedNameValues = material.setValues(nameValues);
        materialStore.update(material);
        eventSourcingProducer.produceEventSourcing(SourcingEvent.buildUpdateEvent("Shared", "Material", changedNameValues));
    }

    public void removeMaterial(String id) {
        //
        if (!materialStore.existsById(id)) {
            return;
        }

        Material material = materialStore.retrieve(id);
        materialStore.delete(material);
    }
}
