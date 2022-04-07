package examples.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@AllArgsConstructor
class ApplicationBootRedis {

    private final ObjectMapper om;

    @Bean
    RedisTemplate<String, Long> stringLongRedisTemplate(RedisConnectionFactory factory) {
        final RedisTemplate<String, Long> bean = new RedisTemplate<>();
        bean.setConnectionFactory(factory);
        bean.setKeySerializer(RedisSerializer.string());
        bean.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        bean.setHashKeySerializer(RedisSerializer.string());
        bean.setHashValueSerializer(new GenericToStringSerializer<>(Long.class));
        return bean;
    }

    @Bean
    RedisTemplate<String, Double> stringDoubleRedisTemplate(RedisConnectionFactory factory) {
        final RedisTemplate<String, Double> bean = new RedisTemplate<>();
        bean.setConnectionFactory(factory);
        bean.setKeySerializer(RedisSerializer.string());
        bean.setValueSerializer(new GenericToStringSerializer<>(Double.class));
        bean.setHashKeySerializer(RedisSerializer.string());
        bean.setHashValueSerializer(new GenericToStringSerializer<>(Double.class));
        return bean;
    }

    @Bean
    RedisTemplate<String, Object> stringObjectRedisTemplate(RedisConnectionFactory factory) {
        final GenericJackson2JsonRedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer(om);

        final RedisTemplate<String, Object> bean = new RedisTemplate<>();
        bean.setConnectionFactory(factory);
        bean.setKeySerializer(RedisSerializer.string());
        bean.setValueSerializer(redisSerializer);
        bean.setHashKeySerializer(RedisSerializer.string());
        bean.setHashValueSerializer(redisSerializer);
        return bean;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    RedisScript<Long> secondKillScript() {
        final DefaultRedisScript<Long> bean = new DefaultRedisScript<>();
        bean.setLocation(new ClassPathResource("lua/seckill.lua"));
        bean.setResultType(Long.class);
        return bean;
    }

}
