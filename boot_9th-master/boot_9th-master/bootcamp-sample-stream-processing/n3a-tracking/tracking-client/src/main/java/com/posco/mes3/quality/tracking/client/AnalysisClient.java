package com.posco.mes3.quality.tracking.client;

import com.posco.mes3.quality.tracking.domain.entity.AnalysisResult;
import com.posco.mes3.quality.tracking.domain.entity.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "quality-tracking")
public interface AnalysisClient {
    //
    @PostMapping(value = "/analysis/analyze")
    public abstract List<AnalysisResult> analyze(@RequestBody List<Material> materials);

}
