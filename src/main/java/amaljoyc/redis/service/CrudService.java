package amaljoyc.redis.service;

import amaljoyc.redis.api.RequestData;
import amaljoyc.redis.persistence.SampleModel;
import amaljoyc.redis.persistence.SampleModelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by amaljoyc on 29.01.19.
 */
@Service
public class CrudService {

    @Autowired
    private SampleModelRepository repository;

    @Autowired
    private ObjectMapper mapper;

    public SampleModel fetchModel(String id) {
        return repository.findById(id).orElse(null);
    }

    public SampleModel saveModel(String id, RequestData data) {
        String complexData = null;
        try {
            complexData = mapper.writeValueAsString(data.getData());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        SampleModel model = new SampleModel(id, data.getName(), complexData);
        return repository.save(model);
    }
}
