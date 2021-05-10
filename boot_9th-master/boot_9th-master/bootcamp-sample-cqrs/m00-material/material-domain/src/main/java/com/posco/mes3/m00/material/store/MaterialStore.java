package com.posco.mes3.m00.material.store;

import com.posco.mes3.m00.material.entity.Material;

import java.util.List;

public interface MaterialStore {
    //
    public abstract void create(Material material);
    public abstract Material retrieve(String id);
    public abstract void update(Material material);
    public abstract void delete(Material material);
    public abstract boolean existsById(String id);

    public abstract List<Material> retrieveAll();
}
