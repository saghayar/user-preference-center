package com.tgtech.preferencecenter.gateway;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    private final RouteDefinitionLocator locator;

    public GatewayApplication(RouteDefinitionLocator locator) {
        this.locator = locator;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        groups.add(GroupedOpenApi.builder().pathsToMatch("").setGroup("preferences").build());
        groups.add(GroupedOpenApi.builder().pathsToMatch("").setGroup("preference/create").build());
        return groups;
    }
}
