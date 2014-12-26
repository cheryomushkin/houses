package houses.persistence;

import javax.persistence.*;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue(generator = "flat_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "flat_seq", sequenceName = "flat_seq", allocationSize = 1)
    private Long id;

    @Column(name = "number")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private FloorEntity floor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public FloorEntity getFloor() {
        return floor;
    }

    public void setFloor(FloorEntity floor) {
        this.floor = floor;
    }
}
