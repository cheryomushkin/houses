package houses.repository;

import houses.persistence.FloorEntity;
import houses.persistence.HouseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FloorRepository extends CrudRepository<FloorEntity, Long> {
}
