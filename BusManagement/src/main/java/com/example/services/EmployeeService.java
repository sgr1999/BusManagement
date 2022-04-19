package com.example.services;

import java.util.List;

import com.example.dao.EmployeeRepository;
import com.example.entites.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    public Employee addEmp(Employee emp){

        Employee save = employeeRepository.save(emp);
        System.out.println(save);
        return save;
    }

    //Get Employee All
    public List<Employee> getEmp(){

        List<Employee> findAll = employeeRepository.findAll();
        System.out.println(findAll);
        return findAll;
    }

    //Get Employee By Id
    public Employee getEmpById(Long id){

        Employee emp=null;
        try{

           emp  = employeeRepository.findEmpById(id);
            
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return emp;
    }

    //Update Employee By Id
    public Employee updateEmpById(Employee employee ,Long id){

        Employee emp=null;
        try{
            
            emp  = employeeRepository.findEmpById(id);
            
        //   emp.setEmpId(employee.getEmpId());
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setUserName(employee.getUserName());
            emp.setPassword(employee.getPassword());
            emp.setEmployeeType(employee.getEmployeeType());
            emp.setMobileNumber(employee.getMobileNumber());

            Employee save = employeeRepository.save(emp);
            System.out.println(save);
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return emp;
    }

    //Update Employee By Id
    public Employee deleteEmpById(Long id){

        Employee find =null;
        try{
            find = employeeRepository.findEmpById(id);
             employeeRepository.deleteById(id);
            
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return find;
    }
}
