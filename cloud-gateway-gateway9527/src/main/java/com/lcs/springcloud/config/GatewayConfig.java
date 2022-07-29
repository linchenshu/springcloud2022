package com.lcs.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linchenshu
 * @date 2022/7/14 11:11
 **/
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_lcs",r->r.path("/guonei").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
