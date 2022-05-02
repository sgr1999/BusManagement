package com.example.entites;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "first_name")
	@NotEmpty
	@Size(min=2, message = "First name should have at least 2 characters")
	private String firstName;

	@NotEmpty
	@Size(min=2, message = "Last name should have at least 2 characters")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty
	@Email(message = "Check user name properly")
	@Column(name = "user_name", unique = true)
	private String userName;

	@NotEmpty
	@Size(min=8, message = "Password should have at least 8 characters")
	@Column(name = "password")
	private String password;

	@Column(name = "mobile_number")
	@NotEmpty
	@Size(min=10, max = 10, message = "Enter Correct mobile number in 10 digits")
	private String mobileNumber;

	@NotEmpty
	@Column(name = "gender")
	private String gender;


	@Column(name = "age")
	private Long age;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "Customer [age=" + age + ", customerId=" + customerId + ", firstName=" + firstName + ", gender=" + gender
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", password=" + password + ", userName="
				+ userName + "]";
	}

	

}
