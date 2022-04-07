package examples.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.UUID;

/*
压力测试
ab -n 5000 \
    -c 100 \
    -m GET \
    http://localhost:8080/v1/sec-kill?prodId=1000
*/

@Slf4j
@RestController
@RequestMapping("/v1/sec-kill")
class SecondKillController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    @Qualifier("secondKillScript")
    private RedisScript<Long> secKillScript;

    @GetMapping
    String secKill(@RequestParam("prodId") Long prodId) {
        final String userId = UUID.randomUUID().toString();
        final Long result = redisTemplate.execute(secKillScript, Collections.emptyList(), prodId.toString(), userId);
        return String.valueOf(result);
    }

}
