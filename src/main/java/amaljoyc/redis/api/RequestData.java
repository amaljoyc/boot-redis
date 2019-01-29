package amaljoyc.redis.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by amaljoyc on 29.01.19.
 */
@Getter
@Setter
public class RequestData {

    private String name;
    private Map<String, Object> data;
}
