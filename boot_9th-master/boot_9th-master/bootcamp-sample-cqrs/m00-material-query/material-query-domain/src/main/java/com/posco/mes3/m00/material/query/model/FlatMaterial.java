package com.posco.mes3.m00.material.query.model;

import com.google.gson.Gson;
import com.posco.mes3.m00.material.entity.Material;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlatMaterial {
    //
    private String id;
    private String name;
    private double width1;
    private double height1;
    private double thickiness1;

    public FlatMaterial(Material material) {
        //
        this.id = material.getId();
        this.name = material.getName();
        this.width1 = material.getDimensions().get(0).getWidth();
        this.height1 = material.getDimensions().get(0).getHeight();
        this.thickiness1 = material.getDimensions().get(0).getThickiness();
    }

    public FlatMaterial(String id, String name) {
        //
        this.id = id;
        this.name = name;
    }

    public static FlatMaterial sample() {
        //
        Material material = Material.sample();
        FlatMaterial sample = new FlatMaterial(material);
        return sample;
    }

    public static void main(String[] args) {
        //
        System.out.println((new Gson()).toJson(FlatMaterial.sample()));
    }
}
