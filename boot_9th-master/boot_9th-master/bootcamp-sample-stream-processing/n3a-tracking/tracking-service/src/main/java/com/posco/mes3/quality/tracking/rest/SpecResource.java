package com.posco.mes3.quality.tracking.rest;

import com.posco.mes3.quality.tracking.domain.entity.SingleSpec;
import com.posco.mes3.quality.tracking.domain.lifecycle.ServiceLifecycle;
import com.posco.mes3.quality.tracking.domain.spec.SpecService;
import com.posco.mes3.quality.tracking.domain.utils.NameValueList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/spec")
public class SpecResource implements SpecService {
    //
    private final SpecService specService;

    public SpecResource(ServiceLifecycle serviceLifecycle) {
        //
        this.specService = serviceLifecycle.requestSpecService();
    }

    @Override
    @PostMapping(value = "/single")
    public String registerSingleSpec(@RequestBody SingleSpec singleSpec) {
        //
        return specService.registerSingleSpec(singleSpec);
    }

    @Override
    @GetMapping(value = "/single/{specId}")
    public SingleSpec findSingleSpec(@PathVariable String specId) {
        //
        return specService.findSingleSpec(specId);
    }

    @Override
    @PutMapping(value = "/single/{specId}")
    public void modifySingleSpec(@PathVariable String specId, @RequestBody NameValueList nameValues) {
        //
        specService.modifySingleSpec(specId, nameValues);
    }

    @Override
    @DeleteMapping(value = "/single/{specId}")
    public void removeSingleSpec(@PathVariable String specId) {
        //
        specService.removeSingleSpec(specId);
    }
}
