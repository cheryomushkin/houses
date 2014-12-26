package houses.service;

import houses.dao.HouseRepository;
import houses.domain.House;
import houses.persistence.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> all() {
        return StreamSupport.stream(houseRepository.findAll().spliterator(), false)
                .map(entity -> new House(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }

    public House add(final House house) {
        final HouseEntity newHouse = new HouseEntity(house.getName());
        final HouseEntity saved = houseRepository.save(newHouse);
        house.setId(saved.getId());
        return house;
    }
}
