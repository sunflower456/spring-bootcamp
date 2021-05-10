package com.posco.mes3.m00.material.query.lifecycle;

import com.posco.mes3.m00.material.query.store.MaterialFlatStore;

public interface StoreLifecycle {
    //
    public abstract MaterialFlatStore requestMaterialFlatStore();
}
