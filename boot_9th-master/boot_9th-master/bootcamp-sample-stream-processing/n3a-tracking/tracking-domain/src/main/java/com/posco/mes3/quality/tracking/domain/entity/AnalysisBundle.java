package com.posco.mes3.quality.tracking.domain.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class AnalysisBundle {
    //
    private String id;
    private long time;

    private List<AnomalySpec> specs;
    private List<Material> materials;
    private List<AnalysisResult> results;

    public AnalysisBundle() {
        //
        this.id = UUID.randomUUID().toString();
        this.time = System.currentTimeMillis();
    }

    public AnalysisBundle(String id) {
        //
        this();
        this.id = id;
    }

    public void addAnalysisMaterials(List<Material> materials) {
        //
        this.materials = materials;
    }

    public void addAnomalySpec(List<AnomalySpec> anomalySpecs) {
        //
        this.specs = anomalySpecs;
    }

    public void analyze() {
        //
        prepareAnalyze();

        for (AnomalySpec spec: specs) {
            for (Material material: materials) {
                results.add(spec.analyze(material));
            }
        }
    }

    private void prepareAnalyze() {
        //
        if (results == null) {
            results = new ArrayList<>();
        }
    }
}
