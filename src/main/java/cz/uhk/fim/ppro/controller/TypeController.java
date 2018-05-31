package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.ITypeService;
import cz.uhk.fim.ppro.validator.TypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @Autowired
    private TypeValidator typeValidator;

    @RequestMapping(value = "/types", method={org.springframework.web.bind.annotation.RequestMethod.GET} )
    public String listTypes(Model model){
        model.addAttribute("type", new Type());
        model.addAttribute("listTypes", typeService.getAll());

        return "types";
    }

    @RequestMapping(value = "/manage/type/create", method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String createType(Model model) {
        model.addAttribute("typeForm", new Type());

        return "createType";
    }

    @RequestMapping(value={"/manage/type/create"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String createType(@org.springframework.web.bind.annotation.ModelAttribute("typeForm") Type typeForm, BindingResult bindingResult) {
        typeValidator.validate(typeForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createType";
        }
        typeService.create(typeForm);

        return "redirect:/types";
    }

    @RequestMapping({"/manage/type/remove/{id}"})
    public String deleteType(@PathVariable("id") int id) {
        typeService.delete(typeService.read(Integer.valueOf(id)));

        return "redirect:/types";
    }

    @RequestMapping(value={"/manage/type/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String editType(@PathVariable("id") int id, Model model) {
        model.addAttribute("typeForm", typeService.read(Integer.valueOf(id)));
        model.addAttribute("listTypes", typeService.getAll());

        return "editType";
    }

    @RequestMapping(value={"/manage/type/edit/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String saveType(@org.springframework.web.bind.annotation.ModelAttribute("typeForm") Type typeForm, BindingResult bindingResult) {
        typeValidator.validate(typeForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editType";
        }
        typeService.update(typeForm);

        return "redirect:/types";
    }

    @RequestMapping(value = "/type/detail/{id}", method = RequestMethod.GET)
    public String detailType(@PathVariable("id") int id, Model model){
        model.addAttribute("typeForm", typeService.read(id));
        return "detailType";
    }

}
