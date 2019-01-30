package amaljoyc.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
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
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(properties.getPool().getMaxTotal());
        poolConfig.setMaxIdle(properties.getPool().getMaxIdle());
        poolConfig.setMinIdle(properties.getPool().getMinIdle());
        poolConfig.setTestOnBorrow(properties.getPool().getTestOnBorrow());

        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig)
                .build();

        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(
                properties.getHost(), properties.getPort());
        RedisPassword redisPassword = RedisPassword.of(properties.getPassword());
        standaloneConfig.setPassword(redisPassword);

        JedisConnectionFactory factory = new JedisConnectionFactory(standaloneConfig, clientConfig);
        return factory;
    }
}
