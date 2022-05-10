package com.example.services;

import java.util.List;

import com.example.dao.EmployeeRepository;
import com.example.entites.Employee;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Add Employee
    public Employee addEmp(Employee emp){

        Employee save = null;
        try {
            emp.setPassword(passwordEncoder.encode(emp.getPassword()));
            save = employeeRepository.save(emp);
            System.out.println(save);

            return save;
        } 
        catch(DataIntegrityViolationException e1){
            System.out.println("UserName Already exist in database");

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    //Get Employee All
    public List<Employee> getEmp(){

        
            List<Employee> findAll = employeeRepository.findAll();

            System.out.println("-----------"+findAll);

            if (findAll.size()<=0) {
                throw new ResourceNotFoundException();
            }
        return findAll;
       
    }

    //Get Employee By Id
    public Employee getEmpById(Long id){

        Employee emp=null;
       

           emp  = employeeRepository.findById(id)
           .orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
            
           return emp;
      
    }

    //Update Employee By Id
    public Employee updateEmpById(Employee employee ,Long id){

        Employee emp=null;
        try{
            
            emp  = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
            
            
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setUserName(employee.getUserName());
            emp.setPassword(employee.getPassword());
            emp.setEmployeeType(employee.getEmployeeType());
            emp.setMobileNumber(employee.getMobileNumber());

            Employee save = employeeRepository.save(emp);
            System.out.println(save);

            return save;
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return null;
    }

    //delete Employee By Id
    public void deleteEmpById(Long id){

       Employee emp  = employeeRepository.findById(id)
           .orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));

           employeeRepository.delete(emp);
    }
}
