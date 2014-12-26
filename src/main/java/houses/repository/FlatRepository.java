package houses.repository;

import houses.persistence.FlatEntity;
import houses.persistence.HouseEntity;
import org.springframework.data.repository.CrudRepository;

public interface FlatRepository extends CrudRepository<FlatEntity, Long> {
}
