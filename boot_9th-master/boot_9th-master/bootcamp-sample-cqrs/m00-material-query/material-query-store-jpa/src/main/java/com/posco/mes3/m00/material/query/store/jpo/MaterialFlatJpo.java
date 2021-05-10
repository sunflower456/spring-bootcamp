package com.posco.mes3.m00.material.query.store.jpo;

import com.posco.mes3.m00.material.query.model.FlatMaterial;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MaterialFlatJpo {
    //
    @Id
    private String id;
    private String name;
    private double width1;
    private double height1;
    private double thickiness1;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="materialId")
    private List<MaterialDimensionJpo> dimensionJpos;

    public MaterialFlatJpo() {
        //
        dimensionJpos = new ArrayList<>();
    }

    public MaterialFlatJpo(FlatMaterial material) {
        //
        this();

        this.id = material.getId();
        this.name = material.getName();
        this.width1 = material.getWidth1();
        this.height1 = material.getHeight1();
        this.thickiness1 = material.getThickiness1();
    }

    public FlatMaterial toDomain() {
        //
        FlatMaterial material = new FlatMaterial(this.id, this.name);
        material.setWidth1(this.width1);
        material.setHeight1(this.height1);
        material.setThickiness1(this.thickiness1);
        return material;
    }

}
