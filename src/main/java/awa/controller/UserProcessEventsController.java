package awa.controller;

import awa.model.Event;
import awa.service.EventService;
import awa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserProcessEventsController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user_process_events", method = RequestMethod.GET)
    public String eventIndex(Model model){
        model.addAttribute("event", new Event());
        return "user_process_events";
    }

    private void updateEventList(Model model, List<Event> eventList) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventList", eventList);
    }

//    @RequestMapping(value = "/user_process_events", method = RequestMethod.POST, params = "action=searchEventByDate")
//    public String listEventByDate(@RequestParam("date") Date date, Model model) {
//        updateEventList(model, eventService.findByDate(date));
//        return "user_process_events";
//    }

    @RequestMapping(value = "/user_process_events", method = RequestMethod.POST, params = "action=listAllEvents")
    public String listAllEvents(Model model){
        updateEventList(model, eventService.findAll());
        return "user_process_events";
    }

//    @RequestMapping(value = "/user_process_events", method = RequestMethod.POST, params = "action=listAllEventsOfCurrentUser")
//    public String listAllOwnEvents(Model model){
//      // TODO ???  updateEventList(model, eventService.findEventsByUser(user));
//        return "user_process_events";
//    }

    @RequestMapping(value = "/user_process_events", method = RequestMethod.POST, params = "action=userAttendEvent")
    public String enrollToCourse(@RequestParam("id") Integer id, Model model, HttpSession httpSession){
        eventService.addUserById(id, Integer.parseInt(httpSession.getAttribute("userId").toString()));
        updateEventList(model, eventService.findAll());
        return "user_process_events";
    }
}
