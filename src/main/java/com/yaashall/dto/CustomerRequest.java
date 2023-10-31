package com.yaashall.dto;

import com.yaashall.utils.Gender;

import java.time.LocalDateTime;

public class CustomerRequest {

    private String customerName;
    private String email;
    private String customerPhone;
    private String address;
    private LocalDateTime dob;
    private Gender gender;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", costumePhone='" + customerPhone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }
}
