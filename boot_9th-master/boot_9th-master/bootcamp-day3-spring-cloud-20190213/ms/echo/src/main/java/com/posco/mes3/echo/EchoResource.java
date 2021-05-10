package com.posco.mes3.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoResource {
    //
    @GetMapping(value = {"", "/"})
    public String echo(@RequestParam(value = "name") String name) {
        //
        System.out.println(String.format("%s is echo!", name));
        return name;
    }
}
