package com.posco.mes3.quality.tracking.domain.entity;

import com.posco.mes3.quality.tracking.domain.exception.UnsupportedNameValueException;
import com.posco.mes3.quality.tracking.domain.utils.JsonUtil;
import com.posco.mes3.quality.tracking.domain.utils.NameValue;
import com.posco.mes3.quality.tracking.domain.utils.NameValueList;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SingleSpec implements AnomalySpec {
    //
    private String id;
    private String name;
    private DoubleRange range;

    public SingleSpec() {
        //
        this.id = UUID.randomUUID().toString();
    }

    public SingleSpec(String id, String name, DoubleRange range) {
        //
        this();
        this.id = id;
        this.name = name;
        this.range = range;
    }

    public SingleSpec(String id, String name, double min, double max) {
        //
        this();
        this.id = id;
        this.name = name;
        this.range = new DoubleRange(min, max);
    }

    @Override
    public AnalysisResult analyze(Material material) {
        //
        boolean isSatisfied = range.isInRange(material.getDimension().getWidth());
        return new AnalysisResult(this, isSatisfied);
    }

    public void setValues(NameValueList nameValues) {
        //
        for(NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch(nameValue.getName()) {
                case "id":
                    this.id = value;
                    break;
                case "name":
                    this.name = value;
                    break;
                default:
                    throw new UnsupportedNameValueException(nameValue.getName());
            }
        }
    }

    public String toJson() {
        //
        return JsonUtil.toJson(this);
    }

    public static SingleSpec fromJson(String json) {
        //
        return JsonUtil.fromJson(json, SingleSpec.class);
    }

    public static SingleSpec sample() {
        //
        SingleSpec sample = new SingleSpec("1234", "SingleSpec#1", 1000, 2000);
        return sample;
    }

    public static void main(String[] args) {
        //
        System.out.println(SingleSpec.sample().toJson());
    }

}
