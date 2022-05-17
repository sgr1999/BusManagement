package com.example.entites;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @NotEmpty
	@Size(min=2, message = "First name should have at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
	@Size(min=2, message = "Last name should have at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
	@Email(message = "Check user name properly")
    @Column(name = "user_name" ,unique = true)
    private String userName;

    @NotEmpty
	@Size(min=8, message = "Password should have at least 8 characters")
    @Column(name = "password")
    private String password;

    @NotEmpty
	@Size(min=10, max = 10, message = "Enter Correct mobile number in 10 digits")
    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "status")
    private String status;

    @Column(name ="role")
    private String role;

    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", password="
                + password + ", status=" + status + ", userId=" + userId + ", userName=" + userName + "]";
    }

}
