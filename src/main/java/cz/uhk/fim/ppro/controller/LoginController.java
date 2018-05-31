package cz.uhk.fim.ppro.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "forward:/index";
        } else {

            /* The user is logged in :) */
            if (error != null)
                model.addAttribute("error", "Zadane jmeno nebo heslo neni spravne");

            if (logout != null)
                model.addAttribute("message", "Byli jste uspesne odhlaseni");

            return "login";
        }
    }
}
