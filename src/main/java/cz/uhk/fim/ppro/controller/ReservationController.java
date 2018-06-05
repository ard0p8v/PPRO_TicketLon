package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.model.User;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IReservationService;
import cz.uhk.fim.ppro.service.IUserService;
import cz.uhk.fim.ppro.validator.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {

    @Autowired(required = true)
    private IReservationService reservationService;

    @Autowired(required = true)
    private IUserService userService;

    @Autowired(required = true)
    private IEventService eventService;

    @Autowired
    private ReservationValidator reservationValidator;

    @RequestMapping(value={"/reservations"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String listReservations(Model model)
    {
        String s = (String)SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByUsername(s);

        model.addAttribute("user", u);
        model.addAttribute("listReservations", reservationService.getReservationsByUser(u.getIdUser()));

        return "reservations";
    }

    @RequestMapping(value={"/events/{id}/manage/reservation/create"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String createReservation(Model model, @PathVariable("id") int id) {
        model.addAttribute("eventReservation", eventService.findEventId(id));
        model.addAttribute("reservationForm", new Reservation(eventService.read(id)));

        return "createReservation";
    }

    @RequestMapping(value={"/events/{id}/manage/reservation/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createReservation(@org.springframework.web.bind.annotation.ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult) {
        reservationValidator.validate(reservationForm, bindingResult);
        if (bindingResult.hasErrors()) {

            return "createReservation";
        }

        reservationService.create(reservationForm);

        int idE = reservationForm.getEvent().getIdEvent();
        Event e = eventService.read(idE);
        int ticketsFree = e.getNumberOfFreeTickets();
        int tickets = reservationForm.getNumberOfTickets();
        ticketsFree = ticketsFree - tickets;
        e.setNumberOfFreeTickets(ticketsFree);
        eventService.update(e);

        return "redirect:/reservations";
    }

    @RequestMapping({"/manage/reservation/remove/{id}"})
    public String deleteReservation(@PathVariable("id") int id) {

        Reservation r = reservationService.read(id);
        int tickets = r.getNumberOfTickets();
        int idE = r.getEvent().getIdEvent();
        Event e = eventService.read(idE);
        int ticketsFree = e.getNumberOfFreeTickets();
        ticketsFree = ticketsFree + tickets;
        e.setNumberOfFreeTickets(ticketsFree);
        eventService.update(e);

        reservationService.delete(reservationService.read(Integer.valueOf(id)));

        return "redirect:/reservations";
    }

    @RequestMapping(value={"/manage/reservation/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editReservation(@PathVariable("id") int id, Model model) {
        model.addAttribute("reservationForm", reservationService.read(Integer.valueOf(id)));
        model.addAttribute("eventReservation", eventService.findEventId(id));
        model.addAttribute("listReservations", reservationService.getAll());

        Reservation r = reservationService.read(id);
        int tickets = r.getNumberOfTickets();
        int idE = r.getEvent().getIdEvent();
        Event e = eventService.read(idE);
        int ticketsFree = e.getNumberOfFreeTickets();
        ticketsFree = ticketsFree - tickets;
        e.setNumberOfFreeTickets(ticketsFree);
        eventService.update(e);

        return "editReservation";
    }

    @RequestMapping(value={"/manage/reservation/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String saveReservation(@org.springframework.web.bind.annotation.ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult) {
        reservationValidator.validate(reservationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editReservation";
        }

        int idE = reservationForm.getEvent().getIdEvent();
        Event e = eventService.read(idE);
        int ticketsFree = e.getNumberOfFreeTickets();
        int tickets = reservationForm.getNumberOfTickets();
        ticketsFree = ticketsFree + tickets;
        e.setNumberOfFreeTickets(ticketsFree);
        eventService.update(e);


        reservationService.update(reservationForm);

        return "redirect:/reservations";
    }


}
