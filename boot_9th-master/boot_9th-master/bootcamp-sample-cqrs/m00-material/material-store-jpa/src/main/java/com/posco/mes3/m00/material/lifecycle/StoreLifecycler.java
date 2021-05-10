package com.posco.mes3.m00.material.lifecycle;

import com.posco.mes3.m00.material.store.MaterialStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {
    //
    private final MaterialStore materialStore;

    public StoreLifecycler(MaterialStore materialStore) {
        //
        this.materialStore = materialStore;
    }

    @Override
    public MaterialStore requestMaterialStore() {
        //
        return materialStore;
    }

}
