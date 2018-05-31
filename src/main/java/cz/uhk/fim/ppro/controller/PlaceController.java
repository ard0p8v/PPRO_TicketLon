package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Place;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.IPlaceService;
import cz.uhk.fim.ppro.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlaceController {

    @Autowired
    private IPlaceService placeService;

    @RequestMapping(value = "/places", method = RequestMethod.GET )
    public String listPlaces(Model model){
        model.addAttribute("place", new Type());
        model.addAttribute("listPlaces", placeService.getAll());

        return "places";
    }

    @RequestMapping(value = "/manage/place/create", method = RequestMethod.GET)
    public String createPlace(Model model) {
        model.addAttribute("placeForm", new Place());

        return "createPlace";
    }

    @RequestMapping(value = "/place/detail/{id}", method = RequestMethod.GET)
    public String detailPlace(@PathVariable("id") int id, Model model){
        model.addAttribute("placeForm", placeService.read(id));
        return "detailPlace";
    }
}
