package com.yaashall.dto;

import com.yaashall.entity.Customer;
import com.yaashall.utils.Gender;

import java.time.LocalDateTime;

public class CustomerResponse {

        private Long customerId;
        private String customerName;
        private String email;
        private String customerPhone;
        private String address;
        private LocalDateTime dob;
        private Gender gender;

    public CustomerResponse(Long customerId,
                            String customerName,
                            String email,
                            String customerPhone,
                            String address,
                            LocalDateTime dob,
                            Gender gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.customerPhone = customerPhone;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public CustomerResponse(Customer customer){

        this(customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getEmail(),
                customer.getCustomerPhone(),
                customer.getAddress(),
                customer.getDob(),
                customer.getGender());
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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
        return "CustomerResponse{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", costumerPhone='" + customerPhone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }
}
