package cz.uhk.fim.ppro.validator;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.News;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewsValidator implements Validator {

    @Autowired
    private INewsService newsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return News.class.equals(clazz);
    }

    @Override
    public void validate(Object e, Errors errors) {
        News news = (News) e;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (news.getName().length() < 6 || news.getName().length() > 200) {
            errors.rejectValue("name", "Size.newsForm.name");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "NotEmpty");
        if (news.getText().length() < 6 || news.getText().length() > 500) {
            errors.rejectValue("text", "Size.newsForm.text");
        }
    }
}
