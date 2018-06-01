package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.model.User;
import cz.uhk.fim.ppro.service.IReservationService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class ReservationController {

    @Autowired(required = true)
    private IReservationService reservationService;

    @Autowired(required = true)
    private IUserService userService;

    @RequestMapping(value={"/reservations"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String listReservations(Model model)
    {
        String s = (String)SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByUsername(s);

        model.addAttribute("user", u);
        model.addAttribute("listReservations", reservationService.getReservationsByUser(u.getIdUser()));

        return "reservations";
    }

    @RequestMapping(value = "/manage/reservation/create", method = RequestMethod.GET)
    public String createReservation(Model model) {
        model.addAttribute("reservationForm", new Reservation());

        return "createReservation";
    }

    @RequestMapping(value={"/manage/reservation/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createReservation(@org.springframework.web.bind.annotation.ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult) {
        reservationService.create(reservationForm);

        return "redirect:/reservations";
    }

    @RequestMapping({"/manage/reservation/remove/{id}"})
    public String deleteReservation(@PathVariable("id") int id) {
        reservationService.delete(reservationService.read(Integer.valueOf(id)));

        return "redirect:/reservations";
    }

    @RequestMapping(value={"/manage/reservation/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editReservation(@PathVariable("id") int id, Model model) {
        model.addAttribute("reservationForm", reservationService.read(Integer.valueOf(id)));
        model.addAttribute("listReservations", reservationService.getAll());

        return "editReservation";
    }

    @RequestMapping(value={"/manage/reservation/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String saveReservation(@org.springframework.web.bind.annotation.ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult) {
        reservationService.update(reservationForm);

        return "redirect:/reservations";
    }


}
