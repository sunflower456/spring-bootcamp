package com.posco.mes3.quality.tracking.domain.logic;

import com.posco.mes3.quality.tracking.domain.exception.AlreadyEntityExistsException;
import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;
import com.posco.mes3.quality.tracking.domain.lifecycle.StoreLifecycle;
import com.posco.mes3.quality.tracking.domain.spec.SpecService;
import com.posco.mes3.quality.tracking.domain.store.SpecStore;
import com.posco.mes3.quality.tracking.domain.utils.NameValueList;

public class SpecLogic implements SpecService {
    //
    private final SpecStore specStore;

    public SpecLogic(StoreLifecycle storeLifecycle) {
        //
        this.specStore = storeLifecycle.requestSpecStore();
    }

    public String registerSingleSpec(SingleSpec singleSpec) {
        //
        if (specStore.exists(singleSpec.getId())) {
            throw new AlreadyEntityExistsException(String.format("SingleSpec(%s) is already exists.", singleSpec.getId()));
        }

        specStore.createSingleSpec(singleSpec);
        return singleSpec.getId();
    }

    public SingleSpec findSingleSpec(String specId) {
        //
        return specStore.retrieveSingleSpec(specId);
    }

    public void modifySingleSpec(String specId, NameValueList nameValues) {
        //
        SingleSpec foundSpec = specStore.retrieveSingleSpec(specId);
        foundSpec.setValues(nameValues);
        specStore.updateSingleSpec(foundSpec);
    }

    public void removeSingleSpec(String specId) {
        //
        if (specStore.exists(specId)) {
            SingleSpec foundSpec = specStore.retrieveSingleSpec(specId);
            specStore.deleteSingleSpec(foundSpec);
        }
    }
}
