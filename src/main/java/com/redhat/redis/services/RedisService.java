package com.redhat.redis.services;

import javax.ws.rs.Path;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisService {

    @Autowired
    ProducerTemplate template;

    @GetMapping("/products/")
    public void save(){
        template.start();
        template.sendBodyAndHeader("direct:start", "total_cursos", "value", 1);
        template.stop();
    }
}
