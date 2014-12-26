package houses.persistence;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "floor")
public class FloorEntity {
    @Id
    @GeneratedValue(generator = "floor_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "floor_seq", sequenceName = "floor_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "house_id")
    private HouseEntity house;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY)
    private List<FlatEntity> flats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    public List<FlatEntity> getFlats() {
        return flats;
    }

    public void setFlats(List<FlatEntity> flats) {
        this.flats = flats;
    }
}
