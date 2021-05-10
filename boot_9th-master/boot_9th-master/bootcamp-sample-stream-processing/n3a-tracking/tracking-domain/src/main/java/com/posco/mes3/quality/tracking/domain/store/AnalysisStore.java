package com.posco.mes3.quality.tracking.domain.store;

import com.posco.mes3.quality.tracking.domain.entity.AnalysisBundle;

import java.util.List;

public interface AnalysisStore {
    //
    public abstract void createAnalysisBundle(AnalysisBundle analysisBundle);
    public abstract List<AnalysisBundle> retrieveAllAnalysisBundles();
    public abstract AnalysisBundle retrieveAnalysisBundle(String analysisBundleId);
}
