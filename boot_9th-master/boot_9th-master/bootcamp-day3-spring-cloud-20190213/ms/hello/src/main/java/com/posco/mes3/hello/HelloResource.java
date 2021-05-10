package com.posco.mes3.hello;

import com.posco.mes3.echo.client.EchoClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    //
    private final EchoClient echoClient;

    public HelloResource(EchoClient echoClient) {
        //
        this.echoClient = echoClient;
    }

    @GetMapping(value = {"", "/"})
    public String sayHello(@RequestParam(value = "name") String name) {
        //
        return "Hello, " + echoClient.echo(name);
    }
}
