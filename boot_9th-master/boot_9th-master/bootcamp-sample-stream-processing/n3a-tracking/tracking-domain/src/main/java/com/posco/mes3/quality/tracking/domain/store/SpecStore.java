package com.posco.mes3.quality.tracking.domain.store;

import com.posco.mes3.quality.tracking.domain.entity.AnomalySpec;
import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;

import java.util.List;

public interface SpecStore {
    //
    public abstract void createSingleSpec(SingleSpec singleSpec);
    public abstract SingleSpec retrieveSingleSpec(String specId);
    public abstract List<AnomalySpec> retrieveAllSingleSpecs();
    public abstract void updateSingleSpec(SingleSpec singleSpec);
    public abstract void deleteSingleSpec(SingleSpec singleSpec);

    public abstract boolean exists(String specId);

}
