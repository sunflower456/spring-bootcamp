package com.posco.mes3.callgate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CallgateResource {
    //
    @GetMapping(value="/test")
    public String say() {
        //
        return "Hello";
    }
}
