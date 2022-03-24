package com.redhat.redis.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.redis.RedisConstants;
import org.springframework.stereotype.Component;

@Component
public class RedisRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:start")
        .setHeader(RedisConstants.COMMAND, constant("SET"))
        .setHeader(RedisConstants.KEY, constant("total_courses"))
//        .setHeader(RedisConstants.FIELD, constant("name"))
        .setHeader(RedisConstants.VALUE, constant("150"))
        .log("Setting value ${header.CamelRedis.Key}")
        .to("spring-redis://localhost:6379")
        .log("${body}");        
    }
    
}
