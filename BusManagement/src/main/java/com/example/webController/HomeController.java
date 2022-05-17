package com.example.webController;

import java.security.Principal;

import com.example.entites.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/signin")
    public String signIn(@ModelAttribute("user") User user, Principal principal, Model model) {
       
        return "signIn";
    }

  
}
