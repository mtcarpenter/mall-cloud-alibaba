package com.mtcarpenter.mall.filter;

import com.mtcarpenter.mall.common.api.ResultCode;
import com.mtcarpenter.mall.common.exception.ApiException;
import com.mtcarpenter.mall.config.IgnoreUrlsConfig;
import com.mtcarpenter.mall.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.key.token}")
    private String REDIS_KEY_TOKEN;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //防止 OPTIONS 请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
            return chain.filter(exchange);
        }
        //白名单请求直接放行
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrlsConfig.getUrls()) {
            if (pathMatcher.match("/**" + path, request.getPath().toString())) {
                return chain.filter(exchange);
            }
        }
        // token 验证
        String token = request.getHeaders().getFirst(tokenHeader);
        if (StringUtils.isBlank(token)){
            log.error("token = {}",token);
            throw new ApiException(ResultCode.UNAUTHORIZED);
        }
        String username = jwtTokenUtil.getUserNameFromToken(token);
        // 待抽离
        String key = REDIS_DATABASE + ":" + REDIS_KEY_TOKEN + ":" + username;
        String resultToken = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(resultToken)) {
            log.error("resultToken = {}",resultToken);
            throw new ApiException(ResultCode.UNAUTHORIZED);
        }
        log.error("resultToken = {}",resultToken);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


}
