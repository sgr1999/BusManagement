package com.example.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    

    @Size(min=2, message = "Name is Required")
    private String firstName;
    @Size(min=2, message = "Last Name is Required")
    private String lastName;
    @NotEmpty
	@Email(message = "Check user name properly")
    private String userName;

    @Size(min=8, message = "Password should have at least 8 characters")
    private String password;
    private String password1;

    @Size(min=10, max = 10, message = "Enter Correct mobile number in 10 digits")
    private String mobileNumber;

    @NotEmpty
    private String gender;

    @NotNull(message = "age is required")
    private Long age;

    
    public CustomerModel() {
    }
    public CustomerModel(String firstName, String lastName, String userName, String password, String password1,
            String mobileNumber, String gender, Long age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.password1 = password1;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.age = age;
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
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }


}
