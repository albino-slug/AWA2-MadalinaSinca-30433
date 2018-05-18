package awa.controller;

import awa.model.Event;
import awa.service.EventService;
import awa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class UserProcessEventsController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user_process_events", method = RequestMethod.GET)
    public String eventIndex(){
        return "user_crud_events";
    }

    private void updateEventList(Model model, List<Event> eventList) {
        model.addAttribute("eventList", eventList);
    }

    @RequestMapping(value = "/userEvents", method = RequestMethod.POST, params = "action=searchEventByDate")
    public String listEventByDate(@RequestParam("date") Date date, Model model) {
        updateEventList(model, eventService.findByDate(date));
        return "user_crud_events";
    }

    @RequestMapping(value = "/userEvents", method = RequestMethod.POST, params = "action=listAllEvents")
    public String listAllEvents(Model model){
        updateEventList(model, eventService.findAll());
        return "user_crud_events";
    }

    @RequestMapping(value = "/userEvents", method = RequestMethod.POST, params = "action=listAllEventsOfCurrentUser")
    public String listAllOwnEvents(Model model){
      // TODO ???  updateEventList(model, eventService.findEventsByUser(user));
        return "user_crud_events";
    }
}
