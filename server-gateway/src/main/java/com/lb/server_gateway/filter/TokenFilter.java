package com.lb.server_gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.lb.server_common.bean.ApiResult;
import com.lb.server_common.bean.ResponseData;
import com.lb.server_gateway.jwt.JwtProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author: liuben
 * @date: 2019/9/5
 */
public class TokenFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestUri = request.getPath().pathWithinApplication().value();

        //不进行拦截的地址
        ServerHttpRequest.Builder mutate = request.mutate();
        if (isStartWith(requestUri)) {
            ServerHttpRequest build = mutate.build();
            return chain.filter(exchange.mutate().request(build).build());
        }

        List<String> headers = exchange.getRequest().getHeaders().get(jwtProperties.getHeader());
        String authToken = CollectionUtils.isEmpty(headers) ? "" : headers.get(0);
        //todo 加入授权验证
        //if (StringUtils.isEmpty(authToken)) {
        //    logger.info("token is empty...");
        //    exchange.getResponse().setStatusCode(HttpStatus.OK);
        //    //exchange.getResponse().setStatusCode(HttpStatus.OK);
        //    byte[] bytes = JSONObject.toJSONString(ResponseData.error(ApiResult.TO_LOGIN)).getBytes(StandardCharsets.UTF_8);
        //    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        //    return exchange.getResponse().writeWith(Flux.just(buffer));
        //} else {
        //
        //
        //}
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private boolean isStartWith(String requestUri) {
        String[] ignoreUrlArr = new String[]{"/api/user/celebrity/auth"};
        for (String ignoreUrl : ignoreUrlArr) {
            if (requestUri.startsWith(ignoreUrl)) {
                return true;
            }
        }
        return false;
    }
}
