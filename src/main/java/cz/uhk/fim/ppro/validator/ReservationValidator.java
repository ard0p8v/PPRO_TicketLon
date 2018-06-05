package cz.uhk.fim.ppro.validator;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ReservationValidator implements Validator {

    @Autowired
    private IEventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object r, Errors errors) {
        Reservation reservation = (Reservation) r;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfTickets", "NotEmpty");
        int id = reservation.getEvent().getIdEvent();
        Event e = eventService.read(id);
        int ticketsFree = e.getNumberOfFreeTickets();

        if(reservation.getNumberOfTickets() > ticketsFree) {
            errors.rejectValue("numberOfTickets", "Size.reservationForm.numberOfTickets");
        }
    }
}
