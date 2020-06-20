package com.mtcarpenter.mall.portal.util;

import com.mtcarpenter.mall.common.api.ResultCode;
import com.mtcarpenter.mall.common.exception.ApiException;
import com.mtcarpenter.mall.model.UmsMember;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Slf4j
@Component
public class MemberUtil {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${redis.member}")
    private String member;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取 redis 中用户信息
     *
     * @return
     */
    public UmsMember getRedisUmsMember(HttpServletRequest request) {
        // token 验证
        String token = request.getHeader(tokenHeader);
        if (StringUtils.isBlank(token)) {
            log.error("token = {}", token);
            throw new ApiException(ResultCode.UNAUTHORIZED);
        }
        String username = jwtTokenUtil.getUserNameFromToken(token);
        if (StringUtils.isBlank(username)) {
            log.error("resultToken = {}", username);
            throw new ApiException(ResultCode.UNAUTHORIZED);
        }
        return (UmsMember) redisTemplate.opsForValue().get(username);
    }
}
