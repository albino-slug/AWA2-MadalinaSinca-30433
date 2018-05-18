package awa.controller;

import awa.model.Course;
import awa.service.CourseService;
import awa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserProcessCoursesController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user_process_courses", method = RequestMethod.GET)
    public String courseIndex(Model model){
        model.addAttribute("course", new Course());
        return "user_process_courses";
    }

    private void updateCourseList(Model model, List<Course> courseList) {
        model.addAttribute("course", new Course());
        model.addAttribute("courseList", courseList);
    }

    @RequestMapping(value = "/user_process_courses", method = RequestMethod.POST, params = "action=listAllCourses")
    public String listAllCourses(Model model){
        updateCourseList(model, courseService.findAll());
        return "user_process_courses";
    }

//    @RequestMapping(value = "/user_process_courses", method = RequestMethod.POST, params = "action=listAllCoursesOfCurrentUser")
//    public String listAllOwnCourses(Model model){
//      // TODO ???  updateCourseList(model, courseService.findCoursesByUser(user));
//        return "user_process_courses";
//    }

    @RequestMapping(value = "/user_process_courses", method = RequestMethod.POST, params = "action=enrollToCourse")
    public String enrollToCourse(@RequestParam("id") Integer id, Model model, HttpSession httpSession){
        courseService.addUserById(id, Integer.parseInt(httpSession.getAttribute("userId").toString()));
        updateCourseList(model, courseService.findAll());
        return "user_process_courses";
    }

}
