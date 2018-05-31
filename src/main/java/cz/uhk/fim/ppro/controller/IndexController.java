package cz.uhk.fim.ppro.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController
{
    public IndexController() {}

    @org.springframework.web.bind.annotation.RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String index()
    {
        return "index";
    }
}
