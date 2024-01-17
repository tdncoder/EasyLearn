package com.easy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/student/course")
    public String adminMemberStudentCourse(){
        return "pages/admin/member_managements/student_course";
    }

    @GetMapping ("/student/course/detail")
    public String adminMemberStudentCourseDetail(){
        return "pages/admin/member_managements/student_course_detail";
    }

    @GetMapping("/student/detail")
    public String adminMemberStudentDetail(){
        return "pages/admin/customerCare_managements/detail_student";
    }

    @GetMapping("/student/replay")
    public String adminMemberStudentDetailReplay(){
        return "pages/admin/customerCare_managements/detail_student_replay";
    }

    @GetMapping("/trainer/detail")
    public String adminMemberTrainerDetail(){
        return "pages/admin/member_managements/detail_trainer";
    }

    @GetMapping("/trainer/course")
    public String adminMemberTrainerCourse(){
        return "pages/admin/member_managements/trainer_course";
    }


    @GetMapping("/trainer/course/detail")
    public String adminMemberTrainerCourseDetail(){
        return "pages/admin/member_managements/trainer_course_detail";
    }

    @GetMapping("/trainer/course/detail/replay")
    public String adminMemberTrainerCourseDetailReplay(){
        return "pages/admin/member_managements/trainer_course_detail_replay";
    }






}
