package com.easy.learn.controller;

import ch.qos.logback.classic.gaffer.GafferConfigurator;
import com.easy.learn.callApi.ManagerService;
import com.easy.learn.dto.Manager.Manager;
import com.easy.learn.dto.Manager.ManagerDTO;

import com.easy.learn.dto.TrainerMember.TrainerDTO;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//import javax.jws.WebParam;
//import java.util.List;
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("managerDTO", new ManagerDTO());
        return "pages/loginPage/register";
    }
//    @PostMapping("/process_register")
//    public String processRegister(ManagerDTO managerDTO) {
//        managerService.create(managerDTO);
//        return "pages/loginPage/register_success";
//    }
@PostMapping("/process_register")
public String processRegister(ManagerDTO managerDTO, Model model) {
    // Check if the username already exists
    ManagerDTO existingManager = managerService.getManagerByUsername(managerDTO.getUsername());
    if (existingManager != null) {
        model.addAttribute("error", "Username already exists");
        return "pages/loginPage/register";
    }

    // Create the manager
    Manager createdManager = managerService.create(managerDTO);
    if (createdManager != null) {
        return "pages/loginPage/register_success";
    } else {
        model.addAttribute("error", "Failed to create manager");
        return "pages/loginPage/register";
    }
}
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("manager", new Manager());
        return "pages/loginPage/login";
    }

    @PostMapping("/process_login")
    public String processLoginPage(@ModelAttribute("manager") ManagerDTO managerDTO, Model model , HttpSession session) {
        String username = managerDTO.getUsername();
        String password = managerDTO.getPassword();
            ManagerDTO authenticatedManager = managerService.signIn(username, password);
            if (authenticatedManager.getData()!=null && authenticatedManager.getData().getId()!=null) {
                session.setAttribute("username", username);
                model.addAttribute("username", managerDTO.getUsername());
                return "pages/admin/index_after_login";
            } else {
                model.addAttribute("error", "Username không tồn tại hoặc mật khẩu sai.");
                return "pages/loginPage/login";
            }
    }



    @GetMapping("/admin/index")
    public String showAdminIndexPage() {
        return  "pages/admin/index";
    }



}