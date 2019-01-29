package amaljoyc.redis.persistence;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.redis.core.RedisHash;

/**
 * Created by amaljoyc on 29.01.19.
 */
@RedisHash
public class SampleModel {

    @Id
    @Getter
    private final String id;

    @Getter
    private final String name;

    @Getter
    private final String complexData;

    @PersistenceConstructor
    public SampleModel(String id, String name, String complexData) {
        this.id = id;
        this.name = name;
        this.complexData = complexData;
    }
}
