package com.posco.mes3.m00.material.lifecycle;

import com.posco.mes3.m00.material.logic.MaterialLogic;
import com.posco.mes3.m00.material.spec.MaterialService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {
    //
    private final StoreLifecycle storeLifecycle;
    private final ProxyLifecycle proxyLifecycle;

    public ServiceLifecycler(StoreLifecycle storeLifecycle, ProxyLifecycle proxyLifecycle) {
        //
        this.storeLifecycle = storeLifecycle;
        this.proxyLifecycle = proxyLifecycle;
    }

    public MaterialService requestMaterialService() {
        //
        return new MaterialLogic(storeLifecycle, proxyLifecycle);
    }

}
