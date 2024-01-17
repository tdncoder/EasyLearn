package com.easy.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showIndexPage() {
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup";
    }
    @GetMapping("/basic")
    public String showBasicSite() {
        return "basic";
    }

    @GetMapping("/lesson")
    public String showLessonSite(){return "lesson";}
    @GetMapping("/fragments")
    public String showFragmentsSite(){return "fragments";}


    @GetMapping("/show/student-take-lesson")
    public String showSTLsite(){return "student-take-lesson";}

    @GetMapping("/show/take-lesson-2")
    public String showTL2site(){return "take-lesson-2";}


    @GetMapping("/show/student-take-course")
    public String showSTCsite(){return "student-take-course";}

    @GetMapping("/show/courses")
    public String showCsite(){return "courses";}

    @GetMapping("/show/quiz")
    public String showQsite(){return "student-take-quiz";}


 }
