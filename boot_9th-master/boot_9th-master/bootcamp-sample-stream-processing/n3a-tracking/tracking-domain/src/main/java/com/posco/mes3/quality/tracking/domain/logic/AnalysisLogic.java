package com.posco.mes3.quality.tracking.domain.logic;

import com.posco.mes3.quality.tracking.domain.entity.AnalysisBundle;
import com.posco.mes3.quality.tracking.domain.entity.AnalysisResult;
import com.posco.mes3.quality.tracking.domain.entity.Material;
import com.posco.mes3.quality.tracking.domain.lifecycle.StoreLifecycle;
import com.posco.mes3.quality.tracking.domain.spec.AnalysisService;
import com.posco.mes3.quality.tracking.domain.store.SpecStore;

import java.util.List;

public class AnalysisLogic implements AnalysisService {
    //
    private final SpecStore specStore;

    public AnalysisLogic(StoreLifecycle storeLifecycle) {
        //
        this.specStore = storeLifecycle.requestSpecStore();
    }

    //
    @Override
    public List<AnalysisResult> analyze(List<Material> materials) {
        //
        AnalysisBundle analysisBundle = new AnalysisBundle();

        analysisBundle.addAnomalySpec(specStore.retrieveAllSingleSpecs());
        analysisBundle.addAnalysisMaterials(materials);

        analysisBundle.analyze();

        return analysisBundle.getResults();
    }
}
