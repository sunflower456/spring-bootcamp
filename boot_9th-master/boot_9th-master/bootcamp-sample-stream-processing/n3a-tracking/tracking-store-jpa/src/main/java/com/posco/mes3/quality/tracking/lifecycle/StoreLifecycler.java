package com.posco.mes3.quality.tracking.lifecycle;

import com.posco.mes3.quality.tracking.domain.lifecycle.StoreLifecycle;
import com.posco.mes3.quality.tracking.domain.store.SpecStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {
    //
    private final SpecStore specStore;

    public StoreLifecycler(SpecStore specStore) {
        //
        this.specStore = specStore;
    }

    @Override
    public SpecStore requestSpecStore() {
        //
        return this.specStore;
    }
}
