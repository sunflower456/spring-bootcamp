package com.posco.mes3.m00.material.query.rest;

import com.posco.mes3.m00.material.query.lifecycle.ServiceLifecycle;
import com.posco.mes3.m00.material.query.model.FlatMaterial;
import com.posco.mes3.m00.material.query.spec.MaterialQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MaterialQueryResource implements MaterialQueryService {
    //
    private final MaterialQueryService materialQueryService;

    public MaterialQueryResource(ServiceLifecycle serviceLifecycle) {
        //
        this.materialQueryService = serviceLifecycle.requestMaterialQueryService();
    }

    public void registerMaterial(FlatMaterial flatMaterial) {
        //
        this.materialQueryService.registerMaterial(flatMaterial);
    }

    @GetMapping(value = "/{id}")
    public FlatMaterial findMaterial(@PathVariable(value = "id") String id) {
        //
        return materialQueryService.findMaterial(id);
    }
}
