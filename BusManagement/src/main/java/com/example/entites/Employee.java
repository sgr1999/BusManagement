package com.example.entites;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;

    @NotEmpty
	@Size(min=2, message = "First name should have at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
	@Size(min=2, message = "Last name should have at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
	@Size(min=10, max = 10, message = "Enter Correct mobile number in 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @NotEmpty
	@Email(message = "Check user name properly")
    @Column(name = "user_name", unique=true)
    private String userName;

    @NotEmpty
	@Size(min=8, message = "Password should have at least 8 characters")
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "employee_type")
    private String employeeType;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", employeeType=" + employeeType + ", firstName=" + firstName
                + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", password=" + password + ", userName="
                + userName + "]";
    } 
}
