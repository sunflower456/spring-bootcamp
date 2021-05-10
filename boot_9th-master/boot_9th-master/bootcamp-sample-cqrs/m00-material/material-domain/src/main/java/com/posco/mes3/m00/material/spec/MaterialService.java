package com.posco.mes3.m00.material.spec;

import com.posco.mes3.m00.material.entity.Material;
import com.posco.mes3.share.domain.NameValueList;

public interface MaterialService {
    //
    public abstract String registerMaterial(Material material);
    public abstract Material findMaterialById(String id);
    public abstract void modifyMaterial(String id, NameValueList nameValues);
    public abstract void removeMaterial(String id);
}
