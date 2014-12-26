package houses.domain;

import houses.persistence.FloorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Floor {

    private Long id;

    private List<Room> rooms;

    public Floor() {
    }

    public Floor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static Floor fromEntity(final FloorEntity floorEntity) {
        return new Floor(floorEntity.getId());
    }

    public static Floor fromEntityDeep(final FloorEntity floorEntity) {
        final Floor result = new Floor(floorEntity.getId());
        result.setRooms(floorEntity.getRooms().stream()
                .map(Room::fromEntity)
                .collect(Collectors.toList()));
        return result;
    }
}
