package amaljoyc.redis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by amaljoyc on 30.01.19.
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "amaljoyc.redis")
public class RedisProperties {

    private String host;
    private int port;
    private String password;
    private RedisPool pool;

    @Getter
    @Setter
    public static class RedisPool {

        private Integer maxTotal;
        private Integer maxIdle;
        private Integer minIdle;
        private Boolean testOnBorrow;
    }
}
