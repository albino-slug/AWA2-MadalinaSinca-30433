package awa.controller;

import awa.model.Course;
import awa.service.CourseService;
import awa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class UserProcessCoursesController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user_process_courses", method = RequestMethod.GET)
    public String courseIndex(){
        return "user_process_courses";
    }

    private void updateCourseList(Model model, List<Course> courseList) {
        model.addAttribute("courseList", courseList);
    }

    @RequestMapping(value = "/userCourses", method = RequestMethod.POST, params = "action=searchCourseByDate")
    public String listCourseByDate(@RequestParam("date") Date date, Model model) {
        updateCourseList(model, courseService.findByStartDate(date));
        return "user_process_courses";
    }

    @RequestMapping(value = "/userCourses", method = RequestMethod.POST, params = "action=listAllCourses")
    public String listAllCourses(Model model){
        updateCourseList(model, courseService.findAll());
        return "user_process_courses";
    }
}
