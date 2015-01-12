package houses.service;

import houses.domain.Floor;
import houses.domain.House;
import houses.domain.Room;
import houses.persistence.FloorEntity;
import houses.persistence.HouseEntity;
import houses.persistence.RoomEntity;
import houses.repository.FloorRepository;
import houses.repository.HouseRepository;
import houses.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        final HouseEntity newHouse = new HouseEntity(house.getName(), house.getAddress());
        final HouseEntity saved = houseRepository.save(newHouse);
        Optional.ofNullable(house.getFloors()).orElse(Arrays.asList(new Floor())).stream()
                .forEach(floor -> addFloor(saved, floor));
        house.setId(saved.getId());
        return house;
    }

    private void addFloor(HouseEntity houseEntity, Floor floor) {
        final FloorEntity saved = createFloor(houseEntity, floor);
        houseEntity.getFloors().add(saved);
        Optional.ofNullable(floor.getRooms()).orElse(Arrays.asList(new Room())).stream()
                .forEach(room -> addRoom(saved, room));
        houseRepository.save(houseEntity);
    }

    private FloorEntity createFloor(HouseEntity houseEntity, Floor floor) {
        FloorEntity floorEntity = new FloorEntity();
        floorEntity.setHouse(houseEntity);
        final FloorEntity saved = floorRepository.save(floorEntity);
        floor.setId(saved.getId());
        return saved;
    }

    private void addRoom(FloorEntity floorEntity, Room room) {
        final RoomEntity saved = createRoom(floorEntity, room);
        floorEntity.getRooms().add(saved);
        floorRepository.save(floorEntity);
    }

    private RoomEntity createRoom(FloorEntity floorEntity, Room room) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setFloor(floorEntity);
        final RoomEntity saved = roomRepository.save(roomEntity);
        room.setId(saved.getId());
        return saved;
    }

    public void delete(Long houseId) {
        houseRepository.delete(houseId);
    }

    public House get(final Long houseId) {
        HouseEntity house = houseRepository.findOne(houseId);
        return House.fromEntityDeep(house);
    }

    public House update(final House house) {
        HouseEntity houseEntity = houseRepository.findOne(house.getId());
        house.updateEntity(houseEntity);
        updateFloors(house, houseEntity);
        houseRepository.save(houseEntity);
        return house;
    }

    private void updateFloors(final House house, final HouseEntity houseEntity) {
        houseEntity.getFloors().removeIf(floorEntity -> !house.getFloors().stream()
                .filter(floor -> floorEntity.getId().equals(floor.getId()))
                .findFirst().isPresent());
        house.getFloors().stream().forEach(floor -> {
            if (floor.getId() == null) {
                addFloor(houseEntity, floor);
            } else {
                final FloorEntity floorEntity = houseEntity.getFloors().stream()
                        .filter(entity -> entity.getId().equals(floor.getId()))
                        .findFirst()
                        .orElse(null);
                if (floorEntity != null) {
                    updateRooms(floor, floorEntity);
                    floorRepository.save(floorEntity);
                }
            }
        });
    }

    private void updateRooms(Floor floor, FloorEntity floorEntity) {
        floorEntity.getRooms().removeIf(roomEntity -> !floor.getRooms().stream()
                .filter(room -> roomEntity.getId().equals(room.getId()))
                .findFirst().isPresent());
        floor.getRooms().stream().forEach(room -> {
            if (room.getId() == null) {
                addRoom(floorEntity, room);
            } else {
                final RoomEntity roomEntity = floorEntity.getRooms().stream()
                        .filter(entity -> entity.getId().equals(room.getId()))
                        .findFirst()
                        .orElse(null);
                if (roomEntity != null) {
                    room.updateEntity(roomEntity);
                    roomRepository.save(roomEntity);
                }
            }
        });
    }
}
