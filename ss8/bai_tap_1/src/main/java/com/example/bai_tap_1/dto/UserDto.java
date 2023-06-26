package com.example.bai_tap_1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    @Size(min = 5,max = 45,message = "Tên đầu không được bé hơn 5 và lớn hơn 45 kí tự")
    private String firstName;

    @Size(min = 5,max = 45,message = "Tên sau không được bé hơn 5 và lớn hơn 45 kí tự")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$",message = "Số điện thoại phải bắt đầu = số 0 và có 10 số")
    private String phoneNumber;

    @Min(value = 18,message = "Tuổi lớn hơn 18")
    private int age;
    @Email(message = "Gmail phải đúng định dạng abc@gmail.com")

    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public UserDto() {
    }

    public UserDto( String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void validate(Object target, Errors errors) {
//       UserDto userDto =(UserDto) target;
//       if (userDto.firstName)
    }
}