package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Role;
import cz.uhk.fim.ppro.model.User;
import cz.uhk.fim.ppro.service.IRoleService;
import cz.uhk.fim.ppro.service.IUserService;
import cz.uhk.fim.ppro.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/users", method = RequestMethod.GET )
    public String listUsers(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userAuth", ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
        model.addAttribute("listUsers", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("rolesList", getUserRoleName(roleService.getAll()));
        return "createUser";
    }

    private List<Role> getUserRoleName(List<Role> roles){
        List<Role> roleNames = new ArrayList<Role>();
        for (Role role : roles){
            role.setRoleName(role.toString());
            roleNames.add(role);
        }
        return roleNames;
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        model.addAttribute("rolesList", getUserRoleName(roleService.getAll()));

        if (bindingResult.hasErrors()) {
            return "createUser";
        }
        userService.create(userForm);
        return "redirect:/users";
    }

    @RequestMapping(value = "/admin/user/remove/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!userService.read(id).getUsername().equals(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername())) {
            userService.delete(userService.read(id));
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET )
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("userForm", userService.read(id));
        model.addAttribute("rolesList", getUserRoleName(roleService.getAll()));
        model.addAttribute("listUser", userService.getAll());

        return "editUser";
    }

    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.POST )
    public String saveUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        model.addAttribute("rolesList", getUserRoleName(roleService.getAll()));

        if (bindingResult.hasErrors()) {
            return "editUser";
        }

        userService.update(user);
        return "redirect:/users";
    }
}
