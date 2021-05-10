package com.posco.mes3.quality.tracking.domain.lifecycle;

import com.posco.mes3.quality.tracking.domain.spec.AnalysisService;
import com.posco.mes3.quality.tracking.domain.spec.SpecService;

public interface ServiceLifecycle {
    //
    public abstract SpecService requestSpecService();
    public abstract AnalysisService requestAnalysisService();
}
