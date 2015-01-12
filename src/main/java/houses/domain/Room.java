package houses.domain;

import houses.persistence.RoomEntity;

public class Room {

    private Long id;

    private String tenant;

    public Room() {
    }

    public Room(Long id, String tenant) {
        this.id = id;
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public static Room fromEntity(final RoomEntity roomEntity) {
        return new Room(roomEntity.getId(), roomEntity.getTenant());
    }

    public void updateEntity(RoomEntity roomEntity) {
        roomEntity.setTenant(getTenant());
    }
}
