package com.easy.learn.web.controller;


import com.easy.learn.web.callApi.JwtCallService;
import com.easy.learn.web.dto.authentication.AuthenticationResponse;
import com.easy.learn.web.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    JwtCallService service;

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("userDTO") UserDTO userDTO, RedirectAttributes ra){
//        AuthenticationResponse response = service.registerUser(userDTO);
//        if (response == null) {
//            ra.addFlashAttribute("msg", "Email already been used");
//            return "redirect:/signup";
//        }
//        else {
//            Coo
//            return "redirect:/basic";
//        }
//
//
//    }

//    @PostMapping("/authenticate")
//    public String authenticate(@RequestBody ) {
//
//    }

//    when clicking submit
//      -> if status == 403
//      -> show error message
//      receive toke then set token to cookie??







//    Sample code

/*
public String generateToken(Model m,
                            HttpSession session,
                            @ModelAttribute JwtRequest jwtRequest,
                            HttpServletResponse res) throws Exception
{
    System.out.println(jwtRequest);
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
    } catch (UsernameNotFoundException e) {

        session.setAttribute("msg","Bad Credentials");
        return "redirect:/login";

    } catch(BadCredentialsException e)
    {
        session.setAttribute("msg","Bad Credentials");
        return "redirect:/login";
    }

    // fine area..

    try {

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());



        System.out.println("userDetails.getUsername: "   +userDetails.getUsername());


        final String token =	jwtUtil.generateToken(userDetails);


        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(Integer.MAX_VALUE);
        res.addCookie(cookie);


        System.out.println("token: " + token);



        return "redirect:/user/";
    }catch(Exception e)
    {
        session.setAttribute("msg","Credentials were right But something went wrong!!");
        return "redirect:/login";
    }
}


    @GetMapping("/log_out")
    public String logout(HttpServletRequest request,HttpServletResponse res,Model m,HttpSession session) {


        String msg = null;

        Cookie[] cookies2 = request.getCookies();
        for(int i = 0; i < cookies2.length; i++)
        {
            if (cookies2[i].getName().equals("token"))
            {
                cookies2[i].setMaxAge(0);
                res.addCookie(cookies2[i]);
                msg = "Logout successfully";

            }

        }
        session.setAttribute("msg", msg);


        return "redirect:/login";

    }
    */
}
