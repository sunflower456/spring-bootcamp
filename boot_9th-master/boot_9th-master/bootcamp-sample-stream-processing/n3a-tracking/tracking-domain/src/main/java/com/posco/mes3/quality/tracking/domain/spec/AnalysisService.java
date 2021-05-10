package com.posco.mes3.quality.tracking.domain.spec;

import com.posco.mes3.quality.tracking.domain.entity.AnalysisResult;
import com.posco.mes3.quality.tracking.domain.entity.Material;

import java.util.List;

public interface AnalysisService {
    //
    public abstract List<AnalysisResult> analyze(List<Material> materials);
}
