package com.posco.mes3.quality.tracking.stream;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TotalTrackingCount {
    //
    private int totalCount;

    public TotalTrackingCount(int totalCount) {
        //
        this.totalCount = totalCount;
    }

    public String toJson() {
        //
        return (new Gson()).toJson(this);
    }
}
