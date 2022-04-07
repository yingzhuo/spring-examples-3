package examples.redis;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
class DataInit implements ApplicationRunner {

    private final RedisTemplate<String, Long> stringLongRedisTemplate;

    @Override
    public void run(ApplicationArguments args) {
        log.info("初始化数据");

        final long prodId = 1000L;
        final long prodInv = 20L;

        final String redisKey = String.format("prod:{%d}:inv", prodId);

        stringLongRedisTemplate.opsForValue()
                .set(redisKey, prodInv);

        Long count = stringLongRedisTemplate.opsForValue()
                .get(redisKey);

        log.debug("商品'{}'库存已初始化: {}件", prodId, count);
    }

}
