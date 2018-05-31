package cz.uhk.fim.ppro.validator;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TypeValidator implements Validator {

    @Autowired
    private IEventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object e, Errors errors) {
        Type type = (Type) e;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (type.getName().length() < 6 || type.getName().length() > 200) {
            errors.rejectValue("name", "Size.typeForm.type");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        if (type.getDescription().length() < 6 || type.getDescription().length() > 500) {
            errors.rejectValue("description", "Size.typeForm.description");
        }
    }
}
