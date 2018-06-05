package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.News;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.INewsService;
import cz.uhk.fim.ppro.validator.NewsValidator;
import cz.uhk.fim.ppro.validator.TypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private NewsValidator newsValidator;

    @RequestMapping(value = "/news", method={org.springframework.web.bind.annotation.RequestMethod.GET} )
    public String listNews(Model model){
        model.addAttribute("news", new News());
        model.addAttribute("listNews", newsService.getAll());

        return "news";
    }

    @RequestMapping(value={"/news"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String listNewsFilter(Model model, @RequestParam("filter") String filter)
    {
        model.addAttribute("news", new News());
        model.addAttribute("listNews", newsService.getNewsByName(filter));

        return "news";
    }

    @RequestMapping(value = "/manage/news/create", method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String createNews(Model model) {
        model.addAttribute("newsForm", new News());

        return "createNews";
    }

    @RequestMapping(value={"/manage/news/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createNews(@org.springframework.web.bind.annotation.ModelAttribute("newsForm") News newsForm, BindingResult bindingResult) {
        newsValidator.validate(newsForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createNews";
        }
        newsService.create(newsForm);

        return "redirect:/news";
    }

    @RequestMapping({"/manage/news/remove/{id}"})
    public String deleteNews(@PathVariable("id") int id) {
        newsService.delete(newsService.read(Integer.valueOf(id)));

        return "redirect:/news";
    }

    @RequestMapping(value={"/manage/news/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editNews(@PathVariable("id") int id, Model model) {
        model.addAttribute("newsForm", newsService.read(Integer.valueOf(id)));
        model.addAttribute("listNews", newsService.getAll());

        return "editNews";
    }

    @RequestMapping(value={"/manage/news/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String saveNews(@org.springframework.web.bind.annotation.ModelAttribute("newsForm") News newsForm, BindingResult bindingResult) {
        newsValidator.validate(newsForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editNews";
        }
        newsService.update(newsForm);

        return "redirect:/news";
    }

    @RequestMapping(value = "/news/detail/{id}", method = RequestMethod.GET)
    public String detailNews(@PathVariable("id") int id, Model model){
        model.addAttribute("newsForm", newsService.read(id));
        return "detailNews";
    }
}
