package com.posco.mes3.m00.material.query.store.jpo;

import com.posco.mes3.share.domain.Dimension;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class MaterialDimensionJpo {
    //
    @Id
    private String id;
    private double width;
    private double height;
    private double thickness;

    public MaterialDimensionJpo(Dimension dimension) {
        //
        this.id = UUID.randomUUID().toString();
        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
        this.thickness = dimension.getThickiness();
    }

    public Dimension toDomain() {
        //
        return new Dimension(width, height, thickness);
    }
}
