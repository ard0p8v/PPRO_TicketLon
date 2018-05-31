package cz.uhk.fim.ppro.controller;

import cz.uhk.fim.ppro.model.Role;
import cz.uhk.fim.ppro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {

    @Autowired(required = true)
    private IRoleService roleService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String listRoles(Model model){
        model.addAttribute("role", new Role());
        model.addAttribute("listRoles", roleService.getAll());
        return "role";
    }

    //for add and update role both
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public String addRole(@ModelAttribute("role") Role r){
        if( r.getIdRole() == null){
            //new role, add it
            roleService.create(r);
        } else {
            //existing role, call update
            roleService.update(r);
        }
        return "redirect:/roles";
    }

    @RequestMapping("/role/remove/{id}")
    public String deleteRole(@PathVariable("id") int id){
        roleService.delete(roleService.read(id));
        return "redirect:/roles";
    }

    @RequestMapping("/role/edit/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
        model.addAttribute("role", roleService.read(id));
        model.addAttribute("listRoles", roleService.getAll());

        return "role";
    }

}
