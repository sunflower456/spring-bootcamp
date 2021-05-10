package com.posco.mes3.sourcing.store.jpo;

import com.google.gson.Gson;
import com.posco.mes3.share.domain.NameValueList;
import com.posco.mes3.shared.event.SourcingEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SourceJpo {
    //
    @Id
    private String uuid;
    private String id;
    private String chainName;
    private long time;

    private String entityName;
    private SourcingEvent.EventType eventType;
    private String json;

    public SourceJpo() {
        //
        this.uuid = UUID.randomUUID().toString();
    }

    public SourceJpo(SourcingEvent sourcingEvent) {
        //
        this();

        this.id = sourcingEvent.getId();
        this.chainName = sourcingEvent.getChainName();
        this.time = sourcingEvent.getTime();

        this.eventType = sourcingEvent.getEventType();
        this.entityName = sourcingEvent.getEntityName();
        this.json = sourcingEvent.getNameValueJson();

    }

    public SourcingEvent toDomain() {
        //
        NameValueList nameValues = (new Gson()).fromJson(this.json, NameValueList.class);

        SourcingEvent sourcingEvent = new SourcingEvent(this.id, this.time);
        sourcingEvent.setChainName(this.chainName);
        sourcingEvent.setEntityName(this.entityName);
        sourcingEvent.setEventType(this.eventType);
        sourcingEvent.setNameValues(nameValues);

        return sourcingEvent;
    }
}
