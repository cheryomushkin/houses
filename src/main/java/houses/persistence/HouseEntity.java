package houses.persistence;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class HouseEntity {

    @Id
    @GeneratedValue(generator = "house_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "house_seq", sequenceName = "house_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public HouseEntity(String name) {
        this.name = name;
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
}
