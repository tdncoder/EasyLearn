package com.easy.learn.web.controller;

import com.easy.learn.web.callApi.CourseCallService;
import com.easy.learn.web.consts.UrlPath;
import com.easy.learn.web.dto.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
//@RequestMapping(ApiPath.API + "/courses")
public class CourseController {
    @Value("${stripe.publicKey}")
    private String publicKey;
    @Autowired
    CourseCallService courseCallService;

    @GetMapping(UrlPath.STUDENT_GET_ALL_COURSE)
    public String getAllCourses(Model model) {
        List<Course> courses = courseCallService.getAllCourses();
        model.addAttribute("listCourse", courses);
        return "courses";
    }

    @GetMapping(UrlPath.STUDENT_COURSE_GET_ID)
    public String getCourseById(@PathVariable Long id, Model model) {
        Course course = courseCallService.getCourseById(id);
        if(course.getId() == null) {
            System.out.println("Course not Found!");
        }
        model.addAttribute("detailsCourse", course);
        return "student-course";
    }

    @GetMapping(UrlPath.PAYMENT)
    public String showPaymentPage(@PathVariable Long id, Model model) {
        Course course = courseCallService.getCourseById(id);
        model.addAttribute("publicKey", publicKey);
        model.addAttribute("amount", course.getPrice());
        model.addAttribute("productName", course.getTitle());
        return "billing-payment";
    }



//    @PostMapping("/courses/add")
//    public String addCourse(@RequestBody CourseDTO courseDTO) {
//        courseCallService.addCourse(courseDTO);
//        return "redirect:/courses";
//    }
//
//    @PutMapping("/courses/{id}")
//    public String updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
//        CourseDTO updatedCourse = courseCallService.updateCourse(id, courseDTO);
//        if (updatedCourse != null) {
//            return "redirect:/courses";
//        } else {
//            return "error";
//        }
//    }
//
//    @DeleteMapping("/courses/{id}")
//    public String deleteCourse(@PathVariable Long id) {
//        if (courseCallService.deleteCourse(id)) {
//            return "redirect:/courses";
//        } else {
//            return "error";
//        }
//    }

    }
