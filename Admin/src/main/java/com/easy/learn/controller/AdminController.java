package com.easy.learn.controller;

import com.easy.learn.callApi.ManagerService;
import com.easy.learn.callApi.StudentService;
import com.easy.learn.callApi.TrainerService;
import com.easy.learn.dto.Manager.Manager;
import com.easy.learn.dto.Manager.ManagerDTO;
import com.easy.learn.dto.TrainerMember.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private ManagerService managerService;

    @GetMapping("")
    public String index() {

        return "pages/admin/index";
    }

    @GetMapping("/finance/student")
    public String adminFinanceStudent() {
        return "pages/admin/finance_managements/student";
    }

    @GetMapping("/finance/trainer")
    public String adminFinanceTrainer() {
        return "pages/admin/finance_managements/trainer";
    }

    @GetMapping("/member/student")
    public String adminMemberStudent(Model model) {
        model.addAttribute("studentList", studentService.getAllStudent());
        return "pages/admin/member_managements/view_student";
    }

    @GetMapping("/member/trainer")
    public String adminMemberTrainer(Model model) {
        model.addAttribute("trainerList", trainerService.getAllTrainer());
        return "pages/admin/member_managements/view_trainer";
    }

    @GetMapping("/customerCare/student")
    public String adminCustomerCareStudent() {
        return "pages/admin/customerCare_managements/student";
    }

    @GetMapping("/customerCare/trainer")
    public String adminCustomerCareTrainer() {
        return "pages/admin/customerCare_managements/trainer";
    }


    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "pages/admin/admin_dashboard";
    }

    @GetMapping("/table")
    public String adminTable() {
        return "pages/admin/admin_table";
    }

    @PostMapping("/save")
    public String saveManager(@ModelAttribute("managerDTO") ManagerDTO managerDTO) {
        if (managerDTO.getId() == null) {

            managerService.create(managerDTO);
        } else {
            managerService.update(managerDTO);

        }
        return "redirect:/admin/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        Manager manager = managerService.getManagerByUsername(username).getData();
        model.addAttribute("managerDTO", manager);

        return "pages/admin/admin_profile";
    }


    @GetMapping("/profile/edit")
    public String changeProfile(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username).getData();
        model.addAttribute("managerDTO", manager);
        return "pages/admin/admin_profile_edit";
    }

    //admin user profile other.
    @GetMapping("/profile-other")
    public String adminProfileOther() {
        return "pages/admin/admin_profile_other";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("manager", new ManagerDTO());

        return "pages/loginPage/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("managerDTO", new ManagerDTO());
        return "pages/loginPage/register";
    }
    @PostMapping("/process_register")
    public String processRegister(ManagerDTO managerDTO) {
        managerService.create(managerDTO);
        return "pages/loginPage/register_success";
    }

}








