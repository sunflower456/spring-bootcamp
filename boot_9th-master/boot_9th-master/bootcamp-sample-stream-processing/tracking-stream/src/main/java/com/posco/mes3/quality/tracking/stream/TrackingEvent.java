package com.posco.mes3.quality.tracking.stream;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class TrackingEvent {
    //
    private String id;
    private int abnormalCount;

    public TrackingEvent() {
        //
        this.id = UUID.randomUUID().toString();
    }

    public TrackingEvent(String id) {
        //
        this.id = id;
    }

    public TrackingEvent(String id, int abnormalCount) {
        //
        this(id);
        this.abnormalCount = abnormalCount;
    }

    public static void main(String[] args) {
        //
        String id = UUID.randomUUID().toString();
        int count = 7;

        TrackingEvent sampleEvent = new TrackingEvent(id, count);
        System.out.println((new Gson()).toJson(sampleEvent));
    }

    public static TrackingEvent sample() {
        //
        String id = UUID.randomUUID().toString();
        int count = (new Random()).nextInt(10);

        return new TrackingEvent(id, count);
    }
}
