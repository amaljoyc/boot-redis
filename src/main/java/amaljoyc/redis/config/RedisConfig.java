package amaljoyc.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by amaljoyc on 29.01.19.
 */
@Configuration
@EnableRedisRepositories(basePackages = {"amaljoyc.redis.persistence"})
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(128);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMinIdle(8);
        jedisPoolConfig.setTestOnBorrow(true);

        RedisPassword redisPassword = RedisPassword.of("mypass");
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
        factory.getStandaloneConfiguration().setHostName("localhost");
        factory.getStandaloneConfiguration().setPort(16379);
        factory.getStandaloneConfiguration().setPassword(redisPassword);
        return factory;
    }
}
