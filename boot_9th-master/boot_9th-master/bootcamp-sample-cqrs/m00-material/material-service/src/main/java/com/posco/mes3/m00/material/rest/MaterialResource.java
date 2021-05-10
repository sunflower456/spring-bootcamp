package com.posco.mes3.m00.material.rest;

import com.posco.mes3.m00.material.entity.Material;
import com.posco.mes3.m00.material.lifecycle.ServiceLifecycle;
import com.posco.mes3.m00.material.spec.MaterialService;
import com.posco.mes3.share.domain.NameValueList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class MaterialResource implements MaterialService {
    //
    private final MaterialService materialService;

    public MaterialResource(ServiceLifecycle serviceLifecycle) {
        //
        this.materialService = serviceLifecycle.requestMaterialService();
    }

    @PostMapping(value = {"", "/"})
    public String registerMaterial(@RequestBody Material material) {
        //
        return materialService.registerMaterial(material);
    }

    @GetMapping(value = "/{id}")
    public Material findMaterialById(@PathVariable(value = "id") String id) {
        //
        return materialService.findMaterialById(id);
    }

    @PutMapping(value = "/{id}")
    public void modifyMaterial(@PathVariable(value = "id") String id, @RequestBody NameValueList nameValues) {
        //
        materialService.modifyMaterial(id, nameValues);
    }

    @DeleteMapping(value = "/{id}")
    public void removeMaterial(@PathVariable(value = "id") String id) {
        //
        materialService.removeMaterial(id);
    }

}
