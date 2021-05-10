package com.posco.mes3.sourcing.lifecycle;

import com.posco.mes3.sourcing.store.SourceStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {
    //
    private final SourceStore sourceStore;

    public StoreLifecycler(SourceStore sourceStore) {
        //
        this.sourceStore = sourceStore;
    }

    @Override
    public SourceStore requestSourceStore() {
        //
        return sourceStore;
    }

}
