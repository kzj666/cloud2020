package com.kk.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/*
@author kzj
@date 2020/7/17 - 11:44
*/
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********************come in MyLogGateWayFilter"+ new Date());
        // 要求请求必须带上uname的查询参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("**********用户名为null***********滚");
            // 设置相应状态为NOT_ACCEPTABLE
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 如果通过，则跳到下一个过滤链
        return chain.filter(exchange);
    }

    // 表示加载过滤器的优先级，数字越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
