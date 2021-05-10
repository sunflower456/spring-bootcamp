package com.posco.mes3.quality.tracking.rest;

import com.posco.mes3.quality.tracking.domain.entity.AnalysisResult;
import com.posco.mes3.quality.tracking.domain.entity.Material;
import com.posco.mes3.quality.tracking.domain.lifecycle.ServiceLifecycle;
import com.posco.mes3.quality.tracking.domain.spec.AnalysisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisResource implements AnalysisService {
    //
    private final AnalysisService analysisService;

    public AnalysisResource(ServiceLifecycle serviceLifecycle) {
        //
        this.analysisService = serviceLifecycle.requestAnalysisService();
    }

    @Override
    @PostMapping(value = "/analyze")
    public List<AnalysisResult> analyze(@RequestBody List<Material> materials) {
        //
        return analysisService.analyze(materials);
    }
}
