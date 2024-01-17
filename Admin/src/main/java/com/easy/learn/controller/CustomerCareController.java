package com.easy.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerCare")
public class CustomerCareController {

    @GetMapping("/student/detail")
    public String adminCustomerCareStudentDetail(){
        return "pages/admin/customerCare_managements/detail_student";
    }

    @GetMapping("/student/replay")
    public String adminCustomerCareStudentDetailReplay(){
        return "pages/admin/customerCare_managements/detail_student_replay";
    }

    @GetMapping("/trainer/detail")
    public String adminCustomerCareTrainerDetail(){
        return "pages/admin/customerCare_managements/detail_trainer";
    }

    @GetMapping("/trainer/replay")
    public String adminCustomerCareTrainerDetailReplay(){
        return "pages/admin/customerCare_managements/detail_trainer_replay";
    }



//
//    @GetMapping("")
//    public String customerCareIndex(){
//        return "pages/customerCare/index";
//    }
//
//    @GetMapping("/student")
//    public String customerCareStudent(){
//        return "pages/customerCare/customerCare_student";
//    }
//
//    @GetMapping("/trainer")
//    public String customerCareTrainer(){
//        return "pages/customerCare/customerCare_trainer";
//    }
//
//    @GetMapping("/table")
//    public String customerCareTableIndex(){
//        return "pages/customerCare/customerCare_table";
//    }
//
//    @GetMapping("/dashboard")
//    public String customerCareDashboard(){
//        return "pages/customerCare/customerCare_dashboard";
//    }


}
