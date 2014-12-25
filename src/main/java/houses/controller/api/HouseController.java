package houses.controller.api;

import houses.domain.House;
import houses.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<House> get() {
        return houseService.all();
    }
}
