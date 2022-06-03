package com.example.webController;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.Model.CustomerModel;
import com.example.dao.CustomerRepository;
import com.example.entites.Customer;
import com.example.helper.Message;
import com.example.helper.Message1;
import com.example.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        return "normal/user_dashboard";
    }

    @RequestMapping("/addEmp")
    public String addEmp(Model model, Principal principal) {
        return "normal/employeeRegister";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(Model model) {

        model.addAttribute("customer", new CustomerModel());
        return "normal/customerRegister";
    }

    @RequestMapping(value = "/doAddCustomer", method = RequestMethod.POST)
    public String addCustomer1(@Valid @ModelAttribute("customer") CustomerModel customer, BindingResult result, Model model,
            HttpSession session, Message1 message1) {

        try {

            String userName = customerRepository.findUserName(customer.getUserName());

            if (userName !=null) {
                message1.setMessage("customer alredy registred with email");
                model.addAttribute("customer", customer);
                throw new Exception();
            }

            if (!customer.getPassword().equals(customer.getPassword1())) {
                message1.setMessage("password not matched");
                model.addAttribute("customer", customer);
                throw new Exception();
            }

            if (result.hasErrors()) {
                System.out.println("result : " + result.toString());
                model.addAttribute("customer", customer);
                return "normal/customerRegister";
            }

            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            
           Customer cus = customerService.modelToCustomer(customer);
            Customer c =customerRepository.save(cus);
            System.out.println(c);
            session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
            return "normal/customerRegister";

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            model.addAttribute("customer", customer);
            session.setAttribute("message", new Message(message1.getMessage(), "alert-danger"));

            return "normal/customerRegister";
        }
    }

    @RequestMapping("/showCustomer")
    public String showCustomer(Model model) {


        return "normal/showCustomerDetail";
    }

    @RequestMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(Model model) {

        List<Customer> list = customerService.getAllCustomer();
        return list;
    }

}
