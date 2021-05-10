package com.posco.mes3.quality.tracking.store.jpo;

import com.posco.mes3.quality.tracking.domain.entity.DoubleRange;
import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SPEC_SINGLE")
@NoArgsConstructor
public class SingleSpecJpo {
    //
    @Id
    private String id;
    private String name;
    private String rangeJson;

    public SingleSpecJpo(SingleSpec singleSpec) {
        //
        this.id = singleSpec.getId();
        this.name = singleSpec.getName();
        this.rangeJson = singleSpec.getRange().toJson();
    }

    public SingleSpec toDomain() {
        //
        return new SingleSpec(this.id, this.name, DoubleRange.fromJson(this.rangeJson));
    }
}
