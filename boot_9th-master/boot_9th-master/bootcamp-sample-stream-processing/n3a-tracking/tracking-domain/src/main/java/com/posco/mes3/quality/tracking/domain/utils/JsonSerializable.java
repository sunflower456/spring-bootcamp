package com.posco.mes3.quality.tracking.domain.utils;

public interface JsonSerializable {
    //
    default String toJson() {
        //
        return JsonUtil.toJson(this);
    }
}

