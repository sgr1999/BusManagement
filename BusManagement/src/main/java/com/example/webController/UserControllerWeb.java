package com.example.webController;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import com.example.dao.UserRepository;
import com.example.entites.User;
import com.example.exception.DataAlreadyPresentExceptionHandling;
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
@RequestMapping("/user")
public class UserControllerWeb {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute
    @RequestMapping("/dologin")
    public void addComminData(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println(userName);

        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    }

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        return "normal/user_dashboard";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "normal/addNewUser";
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
                        return "normal/addNewUser";
                    }

                    if (!user.getPassword().equals(user.getPassword1())) {
                        m.setMessage("password not matched");
                        throw new Exception("password not matched");
                    }
            
                    User save = userRepository.save(user);
                    System.out.println(save);
                    session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
                    return "normal/addNewUser";
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("user", user);
                        session.setAttribute("message", new Message("Something went wrong !!",m.getMessage()));
                    return "normal/addNewUser";
                }
      
    }

}
