package houses.service;

import houses.domain.Floor;
import houses.domain.House;
import houses.persistence.HouseEntity;
import houses.repository.FlatRepository;
import houses.repository.FloorRepository;
import houses.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private FlatRepository flatRepository;

    public List<House> all() {
        return StreamSupport.stream(houseRepository.findAll().spliterator(), false)
                .map(House::fromEntity)
                .collect(Collectors.toList());
    }

    public House add(final House house) {
        final HouseEntity newHouse = new HouseEntity(house.getName());
        final HouseEntity saved = houseRepository.save(newHouse);
        house.setId(saved.getId());
        return house;
    }

    public void delete(Long houseId) {
        houseRepository.delete(houseId);
    }

    public House get(final Long houseId) {
        HouseEntity house = houseRepository.findOne(houseId);
        return House.fromEntityDeep(house);
    }
}
