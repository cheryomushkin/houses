package houses.domain;

import houses.persistence.FlatEntity;

public class Flat {

    private Long id;

    private String number;

    public Flat() {
    }

    public Flat(Long id, String number) {
        this.id = id;
        this.number = number;
    }

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

    public static Flat fromEntity(final FlatEntity flatEntity) {
        return new Flat(flatEntity.getId(), flatEntity.getNumber());
    }
}
