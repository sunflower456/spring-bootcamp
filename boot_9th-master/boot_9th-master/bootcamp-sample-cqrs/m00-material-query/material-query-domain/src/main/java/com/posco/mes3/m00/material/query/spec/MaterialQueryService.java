package com.posco.mes3.m00.material.query.spec;

import com.posco.mes3.m00.material.query.model.FlatMaterial;

public interface MaterialQueryService {
    //
    public abstract void registerMaterial(FlatMaterial flatMaterial);
    public abstract FlatMaterial findMaterial(String id);
}
