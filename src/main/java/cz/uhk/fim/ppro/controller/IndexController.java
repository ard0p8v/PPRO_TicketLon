package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "index";
    }
}
