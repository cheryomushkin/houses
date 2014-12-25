package houses.controller.api;

import houses.domain.House;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/house")
public class HouseController {

    @RequestMapping(method = RequestMethod.GET)
    public List<House> get() {
        return Arrays.asList(new House(1l, "House 1"), new House(2l, "House 2"));
    }
}
