package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IPlaceService;
import cz.uhk.fim.ppro.service.ITypeService;
import cz.uhk.fim.ppro.validator.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@org.springframework.web.bind.annotation.SessionAttributes({"typeList", "placeList"})
public class EventController
{
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IPlaceService placeService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private EventValidator eventValidator;

    public EventController() {}


    @RequestMapping(value={"/events"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String listEvents(Model model)
    {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", eventService.getAll());

        return "events";
    }

    @RequestMapping(value={"/events"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String listEventsFiltr(Model model, @RequestParam("filter") String filter)
    {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", eventService.getEventsByName(filter));

        return "events";
    }

    @RequestMapping(value={"/manage/event/create"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String createEvent(Model model) {
        model.addAttribute("typeList", typeService.getAll());
        model.addAttribute("placeList", placeService.getAll());
        model.addAttribute("eventForm", new Event());

        return "createEvent";
    }

    @RequestMapping(value={"/manage/event/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createEvent(@org.springframework.web.bind.annotation.ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
        eventValidator.validate(eventForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createEvent";
        }
        eventService.create(eventForm);

        return "redirect:/events";
    }

    @RequestMapping({"/manage/event/remove/{id}"})
    public String deleteEvent(@PathVariable("id") int id) {
        eventService.delete(eventService.read(Integer.valueOf(id)));

        return "redirect:/events";
    }

    @RequestMapping(value={"/manage/event/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editEvent(@PathVariable("id") int id, Model model) {
        model.addAttribute("typeList", typeService.getAll());
        model.addAttribute("placeList", placeService.getAll());
        model.addAttribute("eventForm", eventService.read(Integer.valueOf(id)));
        model.addAttribute("listEvents", eventService.getAll());

        return "editEvent";
    }

    @RequestMapping(value={"/manage/event/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String saveEvent(@org.springframework.web.bind.annotation.ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult) {
        eventValidator.validate(eventForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editEvent";
        }
        eventService.update(eventForm);

        return "redirect:/events";
    }

    @RequestMapping(value={"/event/detail/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String detailEvent(@PathVariable("id") int id, Model model) {
        model.addAttribute("eventForm", eventService.read(Integer.valueOf(id)));

        return "detailEvent";
    }
}