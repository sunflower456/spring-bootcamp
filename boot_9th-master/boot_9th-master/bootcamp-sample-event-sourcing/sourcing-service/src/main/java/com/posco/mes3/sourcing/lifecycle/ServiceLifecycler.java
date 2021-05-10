package com.posco.mes3.sourcing.lifecycle;

import com.posco.mes3.sourcing.logic.SourceLogic;
import com.posco.mes3.sourcing.spec.SourceService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {
    //
    private final StoreLifecycle storeLifecycle;

    public ServiceLifecycler(StoreLifecycle storeLifecycle) {
        //
        this.storeLifecycle = storeLifecycle;
    }

    @Override
    public SourceService requestSourceService() {
        //
        return new SourceLogic(storeLifecycle);
    }
}
