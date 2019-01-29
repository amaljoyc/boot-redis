package amaljoyc.redis.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amaljoyc on 29.01.19.
 */
@Repository
public interface SampleModelRepository extends CrudRepository<SampleModel, String> {
}
