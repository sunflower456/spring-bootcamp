package com.posco.mes3.m00.material.query.lifecycle;

import com.posco.mes3.m00.material.query.store.MaterialFlatStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {
    //
    private final MaterialFlatStore materialFlatStore;

    public StoreLifecycler(MaterialFlatStore materialFlatStore) {
        //
        this.materialFlatStore = materialFlatStore;
    }

    @Override
    public MaterialFlatStore requestMaterialFlatStore() {
        //
        return materialFlatStore;
    }
}
