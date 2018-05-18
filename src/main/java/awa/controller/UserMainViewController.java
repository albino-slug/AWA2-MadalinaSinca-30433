package awa.controller;

import awa.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserMainViewController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = {"/user_main_view"}, method = RequestMethod.GET)
    public String UserMainViewIndex() {
        return "user_main_view";
    }
}
