package houses.domain;

import houses.persistence.FloorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Floor {

    private Long id;

    private List<Flat> flats;

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

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public static Floor fromEntity(final FloorEntity floorEntity) {
        return new Floor(floorEntity.getId());
    }

    public static Floor fromEntityDeep(final FloorEntity floorEntity) {
        final Floor result = new Floor(floorEntity.getId());
        result.setFlats(floorEntity.getFlats().stream()
                .map(Flat::fromEntity)
                .collect(Collectors.toList()));
        return result;
    }
}
