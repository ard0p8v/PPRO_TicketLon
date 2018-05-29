package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired(required = true)
    private IEventService eventService;

    @Autowired(required = true)
    private IUserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        return "index";
    }
}
