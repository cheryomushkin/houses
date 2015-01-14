package houses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping({"/", "index", "/index/*", "/house", "/house/*"})
    public String index() {
        return "index";
    }
}
