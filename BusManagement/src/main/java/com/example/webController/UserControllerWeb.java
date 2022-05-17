package com.example.webController;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import com.example.dao.UserRepository;
import com.example.entites.User;
import com.example.response.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserControllerWeb {
    
    @Autowired
	private UserRepository userRepository;
    
    @ModelAttribute
    @RequestMapping("/dologin")
    public void addComminData(Model model, Principal principal){
        String userName = principal.getName();
        System.out.println(userName);

        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    }

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal){
        return "normal/user_dashboard";
    }
    
    @RequestMapping("/addUser")
    public String addUser() {
        
       
        return "normal/addNewUser";
    }

    @RequestMapping(value="/doAddUser", method= RequestMethod.POST)
    public String doAddUser(@Valid @ModelAttribute("user") User user, BindingResult result,
                            Model model, HttpSession session) {
    
        if (result.hasErrors()) {
            System.out.println("Error"+result.toString());
            model.addAttribute("user", user);
            return "normal/addNewUser";
        }                        
        


        User save =userRepository.save(user);
        System.out.println(save);
        session.setAttribute("message", new Message("Successfully Registered !!","alert-success"));
        return "normal/addNewUser";
    }

}
