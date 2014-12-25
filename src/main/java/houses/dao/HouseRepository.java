package houses.dao;

import houses.persistence.HouseEntity;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<HouseEntity, Long> {
}
