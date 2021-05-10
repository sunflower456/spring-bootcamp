package com.posco.mes3.quality.tracking.lifecycle;

import com.posco.mes3.quality.tracking.domain.lifecycle.ServiceLifecycle;
import com.posco.mes3.quality.tracking.domain.lifecycle.StoreLifecycle;
import com.posco.mes3.quality.tracking.domain.logic.AnalysisLogic;
import com.posco.mes3.quality.tracking.domain.logic.SpecLogic;
import com.posco.mes3.quality.tracking.domain.spec.AnalysisService;
import com.posco.mes3.quality.tracking.domain.spec.SpecService;
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
    public SpecService requestSpecService() {
        //
        return new SpecLogic(storeLifecycle);
    }

    @Override
    public AnalysisService requestAnalysisService() {
        //
        return new AnalysisLogic(storeLifecycle);
    }
}
