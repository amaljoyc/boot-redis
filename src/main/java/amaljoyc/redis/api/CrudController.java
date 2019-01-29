package amaljoyc.redis.api;

import amaljoyc.redis.persistence.SampleModel;
import amaljoyc.redis.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amaljoyc on 29.01.19.
 */
@RestController
public class CrudController {

    @Autowired
    private CrudService service;

    @GetMapping("/redis/{id}")
    public ResponseEntity<SampleModel> fetch(@PathVariable String id) {
        SampleModel model = service.fetchModel(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/redis/{id}/save")
    public ResponseEntity<SampleModel> save(@PathVariable String id,
                                                 @RequestBody RequestData data) {
        SampleModel savedModel = service.saveModel(id, data);
        return new ResponseEntity<>(savedModel, HttpStatus.ACCEPTED);
    }

}
