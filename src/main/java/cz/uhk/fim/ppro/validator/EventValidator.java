package cz.uhk.fim.ppro.validator;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Autowired
    private IEventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object e, Errors errors) {
        Event event = (Event) e;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        if (event.getTitle().length() < 6 || event.getTitle().length() > 200) {
            errors.rejectValue("title", "Size.eventForm.title");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        if (event.getTitle().length() < 6 || event.getTitle().length() > 500) {
            errors.rejectValue("description", "Size.eventForm.description");
        }
    }
}
