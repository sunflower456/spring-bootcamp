package com.posco.mes3.m00.material;

import com.posco.mes3.m00.material.entity.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="material")
public interface MaterialClient {
    //
    @PostMapping(value = "/")
    public abstract String registerMaterial(@RequestBody Material material);
    @GetMapping(value = "/{id}")
    public abstract ResponseEntity<Material> findMaterialById(@PathVariable(value = "id") String id);
}
