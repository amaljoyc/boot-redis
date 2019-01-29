package amaljoyc.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RedisProperties properties;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(properties.getPool().getMaxTotal());
        jedisPoolConfig.setMaxIdle(properties.getPool().getMaxIdle());
        jedisPoolConfig.setMinIdle(properties.getPool().getMinIdle());
        jedisPoolConfig.setTestOnBorrow(properties.getPool().getTestOnBorrow());

        RedisPassword redisPassword = RedisPassword.of(properties.getPassword());
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
        factory.getStandaloneConfiguration().setHostName(properties.getHost());
        factory.getStandaloneConfiguration().setPort(properties.getPort());
        factory.getStandaloneConfiguration().setPassword(redisPassword);
        return factory;
    }
}
