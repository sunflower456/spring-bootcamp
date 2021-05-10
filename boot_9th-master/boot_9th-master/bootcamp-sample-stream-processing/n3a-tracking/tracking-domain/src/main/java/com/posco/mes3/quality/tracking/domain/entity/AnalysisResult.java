package com.posco.mes3.quality.tracking.domain.entity;

import lombok.Getter;

@Getter
public class AnalysisResult {
    //
    private AnomalySpec anomalySpec;
    private boolean satisfied;

    public AnalysisResult(AnomalySpec anomalySpec, boolean satisfied) {
        //
        this.anomalySpec = anomalySpec;
        this.satisfied = satisfied;
    }
}
