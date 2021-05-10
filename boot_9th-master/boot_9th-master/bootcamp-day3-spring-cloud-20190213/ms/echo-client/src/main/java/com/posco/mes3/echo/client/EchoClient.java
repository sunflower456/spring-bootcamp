package com.posco.mes3.echo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "echo")
public interface EchoClient {
    //
    @GetMapping(value = "/")
    public abstract String echo(@RequestParam(value = "name") String name);
}
