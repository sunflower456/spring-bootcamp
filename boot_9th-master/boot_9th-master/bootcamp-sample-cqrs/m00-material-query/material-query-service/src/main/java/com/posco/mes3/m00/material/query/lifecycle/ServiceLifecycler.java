package com.posco.mes3.m00.material.query.lifecycle;

import com.posco.mes3.m00.material.query.logic.MaterialQueryLogic;
import com.posco.mes3.m00.material.query.spec.MaterialQueryService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {
    //
    private final StoreLifecycle storeLifecycle;

    public ServiceLifecycler(StoreLifecycle storeLifecycle) {
        //
        this.storeLifecycle = storeLifecycle;
    }

    public MaterialQueryService requestMaterialQueryService() {
        //
        return new MaterialQueryLogic(storeLifecycle);
    }
}
