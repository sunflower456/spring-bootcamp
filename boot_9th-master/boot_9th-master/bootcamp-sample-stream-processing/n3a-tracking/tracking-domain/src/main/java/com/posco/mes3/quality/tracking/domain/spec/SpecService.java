package com.posco.mes3.quality.tracking.domain.spec;

import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;
import com.posco.mes3.quality.tracking.domain.utils.NameValueList;

public interface SpecService {
    //
    public abstract String registerSingleSpec(SingleSpec singleSpec);
    public abstract SingleSpec findSingleSpec(String specId);
    public abstract void modifySingleSpec(String specId, NameValueList nameValues);
    public abstract void removeSingleSpec(String specId);
}
