package houses.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "house")
public class HouseEntity {

    @Id
    @GeneratedValue(generator = "house_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "house_seq", sequenceName = "house_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String address;

    @Version
    @Column
    private Integer version;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<FloorEntity> floors = new ArrayList<>();

    public HouseEntity() {
    }

    public HouseEntity(String name, String address) {
        this.name = name;
        this.address = address == null ? "" : address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FloorEntity> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorEntity> floors) {
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
