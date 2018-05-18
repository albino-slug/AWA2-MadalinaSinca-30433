package awa.controller;

import awa.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMainViewController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = {"/admin_main_view"}, method = RequestMethod.GET)
    public String AdminMainViewIndex() {
        return "admin_main_view";
    }

    @RequestMapping(value = "/admin_main_view", method = RequestMethod.POST, params = "redirect=toAdminCrudUsers")
    public String switchToAdminCrudUsers()
    {
        return "redirect:/admin_crud_users";
    }

    @RequestMapping(value = "/admin_main_view", method = RequestMethod.POST, params = "redirect=toAdminCrudEvents")
    public String switchToAdminCrudEvents()
    {
        return "redirect:/admin_crud_events";
    }

    @RequestMapping(value = "/admin_main_view", method = RequestMethod.POST, params = "redirect=toAdminCrudCourses")
    public String switchToAdminCrudCourses()
    {
        return "redirect:/admin_crud_courses";
    }
}
