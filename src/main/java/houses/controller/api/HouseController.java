package houses.controller.api;

import houses.domain.House;
import houses.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<House> getAll() {
        return houseService.all();
    }

    @RequestMapping(value = "/{houseId}", method = RequestMethod.GET)
    public House get(@PathVariable("houseId") final Long houseId) {
        return houseService.get(houseId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public House add(@RequestBody final House house) {
        return houseService.add(house);
    }

    @RequestMapping(value = "/{houseId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("houseId") final Long houseId) {
        houseService.delete(houseId);
    }
}
