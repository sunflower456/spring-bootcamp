package com.posco.mes3.m00.material.event;

import com.posco.mes3.m00.material.entity.Material;
import com.posco.mes3.share.domain.NameValueList;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MaterialEvent {
    //
    private String id;
    private String eventType;
    private long time;

    private Material material;
    private NameValueList changedNameValues;

    public MaterialEvent() {
        //
        this.id = UUID.randomUUID().toString();
        this.time = System.currentTimeMillis();
    }

    public MaterialEvent(Material material) {
        //
        this();
        this.eventType = "Created";
        this.material = material;
    }

    public MaterialEvent(NameValueList nameValues) {
        //
        this();
        this.eventType = "Updated";
        this.changedNameValues = nameValues;
    }

    public static MaterialEvent buildCreateEvent(Material material) {
        //
        return new MaterialEvent(material);
    }

    public static MaterialEvent buildUpdateEvent(NameValueList changedNameValues) {
        //
        return new MaterialEvent(changedNameValues);
    }
}