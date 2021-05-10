package com.posco.mes3.m00.material.store.jpo;

import com.posco.mes3.m00.material.entity.Material;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class MaterialJpo {
    //
    @Id
    private String id;
    private String name;
    private String dimensionJson;

    public MaterialJpo(Material material) {
        //
        this.id = material.getId();
        this.name = material.getName();
        this.dimensionJson = material.toDimensionJson();
    }

    public Material toDomain() {
        //
        Material material = new Material(this.id, this.name);
        material.fromDimensionJson(dimensionJson);
        return material;
    }

}
