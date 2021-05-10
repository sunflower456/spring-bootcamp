package com.posco.mes3.m00.material.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.posco.mes3.share.domain.Dimension;
import com.posco.mes3.share.domain.NameValue;
import com.posco.mes3.share.domain.NameValueList;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Material {
    //
    private String id;
    private String name;
    private List<Dimension> dimensions;

    public Material() {
        //
        this.id = UUID.randomUUID().toString();
        this.dimensions = new ArrayList<Dimension>();
    }

    public Material(String id) {
        //
        this();
        this.id = id;
    }

    public Material(String id, String name) {
        //
        this(id);
        this.name = name;
    }

    public String toDimensionJson() {
        //
        return (new Gson()).toJson(dimensions);
    }

    public void fromDimensionJson(String json) {
        //
        Type listType = new TypeToken<List<Dimension>>() {}.getType();
        this.dimensions = (new Gson()).fromJson(json, listType);
    }

    public static Material sample() {
        //
        String uuid = UUID.randomUUID().toString();
        Material sample = new Material(uuid, "Material#1");
        sample.getDimensions().add(Dimension.sample());
        sample.getDimensions().add(Dimension.sample());
        sample.getDimensions().add(Dimension.sample());
        sample.getDimensions().add(Dimension.sample());
        return sample;
    }

    public static void main(String[] args) {
        //
        System.out.println((new Gson()).toJson(Material.sample()));
    }

    public NameValueList getNameValues() {
        //
        return NameValueList.newInstance("id", this.id).add("name", this.name);
    }

    public NameValueList setValues(NameValueList nameValues) {
        //
        NameValueList delta = new NameValueList();
        for (NameValue nameValue: nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "name":
                    this.name = nameValue.getValue();
                    delta.add(nameValue);
                    break;
                case "id":
                    break;
                default:
                    throw new RuntimeException("NotSupported Property");

            }
        }
        return delta;
    }

}
