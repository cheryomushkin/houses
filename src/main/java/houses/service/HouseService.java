package houses.service;

import houses.domain.Floor;
import houses.domain.House;
import houses.domain.Room;
import houses.persistence.FloorEntity;
import houses.persistence.HouseEntity;
import houses.persistence.RoomEntity;
import houses.repository.RoomRepository;
import houses.repository.FloorRepository;
import houses.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
    private RoomRepository roomRepository;

    public List<House> all() {
        return StreamSupport.stream(houseRepository.findAll().spliterator(), false)
                .map(House::fromEntity)
                .collect(Collectors.toList());
    }

    public House add(final House house) {
        final HouseEntity newHouse = new HouseEntity(house.getName());
        final HouseEntity saved = houseRepository.save(newHouse);
        Optional.ofNullable(house.getFloors()).orElse(Arrays.asList(new Floor())).stream()
                .forEach(floor -> addFloor(saved, floor));
        house.setId(saved.getId());
        return house;
    }

    private void addFloor(HouseEntity houseEntity, Floor floor) {
        FloorEntity floorEntity = new FloorEntity();
        floorEntity.setHouse(houseEntity);
        final FloorEntity saved = floorRepository.save(floorEntity);
        floor.setId(saved.getId());
        houseEntity.getFloors().add(saved);
        Optional.ofNullable(floor.getRooms()).orElse(Arrays.asList(new Room())).stream()
                .forEach(room -> addRoom(saved, room));
        houseRepository.save(houseEntity);
    }

    private void addRoom(FloorEntity floorEntity, Room room) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setFloor(floorEntity);
        final RoomEntity saved = roomRepository.save(roomEntity);
        room.setId(saved.getId());
        floorEntity.getRooms().add(saved);
        floorRepository.save(floorEntity);
    }

    public void delete(Long houseId) {
        houseRepository.delete(houseId);
    }

    public House get(final Long houseId) {
        HouseEntity house = houseRepository.findOne(houseId);
        return House.fromEntityDeep(house);
    }

    public House update(final House house) {
        //todo implement me
        return house;
    }
}
