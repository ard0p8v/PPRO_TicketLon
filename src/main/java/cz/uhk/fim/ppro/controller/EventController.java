package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IEventTypeService;
import cz.uhk.fim.ppro.service.IPlaceService;
import cz.uhk.fim.ppro.validator.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"typeList", "placeList"})
public class EventController {

    @Autowired
    private IEventTypeService eventTypeService;

    @Autowired
    private IPlaceService placeService;

    @Autowired
    private IEventService eventService;

    @Autowired
    private EventValidator eventValidator;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", eventService.getAll());

        return "events";
    }

    @RequestMapping(value = "/manage/event/create", method = RequestMethod.GET)
    public String createEvent(Model model) {
        model.addAttribute("typeList", eventTypeService.getAll());
        model.addAttribute("placeList", placeService.getAll());
        model.addAttribute("eventForm", new Event());

        return "createEvent";
    }

    @RequestMapping(value = "/manage/event/create", method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
        eventValidator.validate(eventForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createEvent";
        }
        eventService.create(eventForm);

        return "redirect:/events";
    }

    @RequestMapping(value = "/manage/event/remove/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        eventService.delete(eventService.read(id));

        return "redirect:/events";
    }

    @RequestMapping(value = "/manage/event/edit/{id}", method = RequestMethod.GET)
    public String editEvent(@PathVariable("id") int id, Model model) {
        model.addAttribute("typeList", eventTypeService.getAll());
        model.addAttribute("placeList", placeService.getAll());
        model.addAttribute("eventForm", eventService.read(id));
        model.addAttribute("listEvents", eventService.getAll());

        return "editEvent";
    }

    @RequestMapping(value = "/manage/event/edit/{id}", method = RequestMethod.POST )
    public String saveEvent(@ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
        eventValidator.validate(eventForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editEvent";
        }
        eventService.update(eventForm);

        return "redirect:/events";
    }

    @RequestMapping(value = "/event/detail/{id}", method = RequestMethod.GET)
    public String detailEvent(@PathVariable("id") int id, Model model){
        model.addAttribute("eventForm", eventService.read(id));

        return "detailEvent";
    }
}
