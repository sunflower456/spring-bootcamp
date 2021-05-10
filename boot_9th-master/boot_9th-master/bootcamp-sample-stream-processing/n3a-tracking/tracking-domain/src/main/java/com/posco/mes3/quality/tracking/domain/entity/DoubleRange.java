package com.posco.mes3.quality.tracking.domain.entity;

import com.posco.mes3.quality.tracking.domain.utils.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DoubleRange {
    //
    private double min;
    private double max;

    public DoubleRange(double min, double max) {
        //
        this.min = min;
        this.max = max;
    }

    public boolean isInRange(double value) {
        //
        return min <= value && value <= max;
    }

    public String toJson() {
        //
        return JsonUtil.toJson(this);
    }

    public static DoubleRange fromJson(String rangeJson) {
        //
        return JsonUtil.fromJson(rangeJson, DoubleRange.class);
    }
}
