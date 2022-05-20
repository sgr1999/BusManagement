package com.example.webController;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.dao.UserRepository;
import com.example.entites.User;
import com.example.helper.Message;
import com.example.helper.Message1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/signin")
    public String signIn(@ModelAttribute("user") User user, Principal principal, Model model) {
       
        return "signIn";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "user/signup";
    }

    @RequestMapping(value = "/doAddUser", method = RequestMethod.POST)
    public String doAddUser(@Valid @ModelAttribute("user") User user, BindingResult result,
    Model model, HttpSession session,Message1 m) {
        
        try {
            
                   
                    String userName = userRepository.getUserName(user.getUserName());

                    if (userName != null) {
                      
                        m.setMessage("alredy registred with this email");
                        System.out.println("alredy registred with this email");
                        throw new Exception("alredy registred with this email");
                    }
            
                    if (result.hasErrors()) {
                        System.out.println("Error" + result.toString());
                        model.addAttribute("user", user);
                        return "user/signup";
                    }

                    if (!user.getPassword().equals(user.getPassword1())) {
                        m.setMessage("password not matched");
                        throw new Exception("password not matched");
                    }
            
                    User save = userRepository.save(user);
                    System.out.println(save);
                    session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
                    return "user/signup";
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("user", user);
                        session.setAttribute("message", new Message(m.getMessage(),"alert-danger"));
                    return "user/signup";
                }
      
    }
}
