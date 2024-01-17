package com.easy.learn.web.controller;

import com.easy.learn.web.callApi.UserCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserCallService userCallService;

//    @GetMapping("/register")
//    public String showRegisterPage(Model model) {
//        model.addAttribute("userDTO", new UserDTO());
//        return "signup";
//    }
//    //    @PostMapping("/process_register")
////    public String processRegister(ManagerDTO managerDTO) {
////        managerService.create(managerDTO);
////        return "pages/loginPage/register_success";
////    }
//    @PostMapping("/process_register")
//    public String processRegister(UserDTO userDTO, Model model) {
//        // Check if the username already exists
//        UserDTO existingUser = userCallService.getUserByUsername(userDTO.getUsername());
//        if (existingUser != null) {
//            model.addAttribute("error", "Username already exists");
//            return "pages/loginPage/register";
//        }
//
//        // Create the manager
//        User createdUser = userCallService.create(userDTO);
//        if (createdUser != null) {
//            return "pages/loginPage/register_success";
//        } else {
//            model.addAttribute("error", "Failed to create manager");
//            return "pages/loginPage/register";
//        }
//    }
//    @GetMapping("/login")
//    public String showLoginPage(Model model) {
//        model.addAttribute("manager", new User());
//        return "pages/loginPage/login";
//    }
//
//    @PostMapping("/process_login")
//    public String processLoginPage(@ModelAttribute("user") UserDTO userDTO, Model model , HttpSession session) {
//        String username = userDTO.getUsername();
//        String password = userDTO.getPassword();
//        UserDTO authenticatedManager = userCallService.signIn(username, password);
//        if (authenticatedManager.getData()!=null && authenticatedManager.getData().getId()!=null) {
//            session.setAttribute("username", username);
//            model.addAttribute("username", userDTO.getUsername());
//            return "pages/admin/index_after_login";
//        } else {
//            model.addAttribute("error", "Username không tồn tại hoặc mật khẩu sai.");
//            return "pages/loginPage/login";
//        }
//    }

}
