package com.posco.mes3.quality.tracking.domain.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NameValue implements JsonSerializable {
    //
    private String name;
    private String value;

    public NameValue(String name, String value) {
        //
        this.setName(name);
        this.setValue(value);
    }

    public static NameValue fromJson(String json) {
        //
        return JsonUtil.fromJson(json, NameValue.class);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public String toSimpleString() {
        //
        return String.format("%s:%s", name, value);
    }

    public static NameValue sample() {
        //
        return new NameValue("name", "Cheolsoo Kim");
    }

    public static void main(String[] args) {
        //
        System.out.println(sample());
        System.out.println(sample().toSimpleString());
    }
}
