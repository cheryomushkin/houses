package houses.persistence;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(generator = "room_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "room_seq", sequenceName = "room_seq", allocationSize = 1)
    private Long id;

    @Column(name = "tenant", nullable = true)
    private String tenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private FloorEntity floor;

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

    public FloorEntity getFloor() {
        return floor;
    }

    public void setFloor(FloorEntity floor) {
        this.floor = floor;
    }
}
