package com.posco.mes3.sourcing.entity;

import com.posco.mes3.share.domain.NameValueList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source {
    //
    private String id;
    private long time;
    private String chainName;
    private String entityName;
    private NameValueList nameValues;
}
