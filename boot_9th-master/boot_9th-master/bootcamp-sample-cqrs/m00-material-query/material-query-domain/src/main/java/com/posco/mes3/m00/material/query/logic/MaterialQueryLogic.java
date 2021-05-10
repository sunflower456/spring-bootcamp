package com.posco.mes3.m00.material.query.logic;

import com.posco.mes3.m00.material.query.lifecycle.StoreLifecycle;
import com.posco.mes3.m00.material.query.model.FlatMaterial;
import com.posco.mes3.m00.material.query.store.MaterialFlatStore;
import com.posco.mes3.m00.material.query.spec.MaterialQueryService;

public class MaterialQueryLogic implements MaterialQueryService {
    //
    private final MaterialFlatStore materialFlatStore;

    public MaterialQueryLogic(StoreLifecycle storeLifecycle) {
        //
        this.materialFlatStore = storeLifecycle.requestMaterialFlatStore();
    }

    public void registerMaterial(FlatMaterial flatMaterial) {
        //
        //
        //
        this.materialFlatStore.create(flatMaterial);
    }

    public FlatMaterial findMaterial(String id) {
        //
        return materialFlatStore.retrieve(id);
    }
}
