package com.posco.mes3.quality.tracking.domain.lifecycle;

import com.posco.mes3.quality.tracking.domain.store.SpecStore;

public interface StoreLifecycle {
    //
    public abstract SpecStore requestSpecStore();
}
