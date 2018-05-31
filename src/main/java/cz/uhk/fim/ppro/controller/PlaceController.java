package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Place;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.IPlaceService;
import cz.uhk.fim.ppro.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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


    @RequestMapping(value={"/manage/place/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createPlace(@org.springframework.web.bind.annotation.ModelAttribute("placeForm") Place placeForm, BindingResult bindingResult) {
        placeService.create(placeForm);

        return "places";
    }

    @RequestMapping({"/manage/place/remove/{id}"})
    public String deletePlace(@PathVariable("id") int id) {
        placeService.delete(placeService.read(Integer.valueOf(id)));

        return "redirect:/places";
    }

    @RequestMapping(value={"/manage/place/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editPlace(@PathVariable("id") int id, Model model) {
        model.addAttribute("placeForm", placeService.read(Integer.valueOf(id)));
        model.addAttribute("listPlaces", placeService.getAll());

        return "editPlace";
    }

    @RequestMapping(value={"/manage/place/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String savePlace(@org.springframework.web.bind.annotation.ModelAttribute("placeForm") Place placeForm, BindingResult bindingResult) {
        placeService.update(placeForm);

        return "redirect:/places";
    }

    @RequestMapping(value = "/place/detail/{id}", method = RequestMethod.GET)
    public String detailPlace(@PathVariable("id") int id, Model model){
        model.addAttribute("placeForm", placeService.read(id));
        return "detailPlace";
    }
}
