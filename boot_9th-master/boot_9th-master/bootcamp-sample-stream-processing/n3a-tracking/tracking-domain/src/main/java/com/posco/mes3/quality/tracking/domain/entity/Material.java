package com.posco.mes3.quality.tracking.domain.entity;

import com.posco.mes3.quality.tracking.domain.utils.JsonUtil;
import com.posco.mes3.share.domain.Dimension;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class Material {
    //
    private String id;
    private Dimension dimension;

    public Material(String id, Dimension dimension) {
        //
        this.id = id;
        this.dimension = dimension;
    }

    public String toJson() {
        //
        return JsonUtil.toJson(this);
    }

    public static Material fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Material.class);
    }

    public static Material sample() {
        //
        Material sample = new Material("1234", new Dimension(1100, 4500, 50));
        return sample;
    }

    public static List<Material> samples() {
        //
        Material normalSample = new Material("1234", new Dimension(1100, 4500, 50));
        Material abnormalSample = new Material("1235", new Dimension(1400, 4500, 50));

        return Arrays.asList(normalSample, abnormalSample);
    }

    public static void main(String[] args) {
        //
        System.out.println(Material.sample().toJson());
        System.out.println(JsonUtil.toJson(Material.samples()));
    }

}
