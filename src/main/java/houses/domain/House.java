package houses.domain;

import houses.persistence.HouseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class House {
    private Long id;
    private String name;
    private String address;
    private List<Floor> floors;

    public House() {
    }

    public House(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public static House fromEntity(final HouseEntity houseEntity) {
        return new House(houseEntity.getId(), houseEntity.getName(), houseEntity.getAddress());
    }    
    

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static House fromEntityDeep(final HouseEntity houseEntity) {
        final House result = new House(houseEntity.getId(), houseEntity.getName(), houseEntity.getAddress());
        result.setFloors(houseEntity.getFloors().stream()
                .map(Floor::fromEntityDeep)
                .collect(Collectors.toList()));
        return result;
    }

	public void updateEntity(HouseEntity houseEntity) {		
		houseEntity.setName(getName());	
		houseEntity.setAddress(getAddress());		
	}   
}
