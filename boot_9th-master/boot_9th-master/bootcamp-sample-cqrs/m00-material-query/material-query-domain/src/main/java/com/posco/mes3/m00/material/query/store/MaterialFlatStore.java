package com.posco.mes3.m00.material.query.store;

import com.posco.mes3.m00.material.query.model.FlatMaterial;

import java.util.List;

public interface MaterialFlatStore {
    //
    public abstract void create(FlatMaterial flatMaterial);
    public abstract FlatMaterial retrieve(String id);
    public abstract void update(FlatMaterial flatMaterial);
    public abstract void delete(FlatMaterial flatMaterial);
    public abstract boolean existsById(String id);

    public abstract List<FlatMaterial> retrieveAll();
}
