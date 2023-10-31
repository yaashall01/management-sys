package com.yaashall.entity;

import com.yaashall.utils.Gender;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Yassine CHALH
 */
@Entity(name = "Customer")
@Table(
        name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_email_unique", columnNames = "email")
        }
)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    @Column(
            name = "customer_id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long customerId;

    @Column(
            name = "customer_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String customerName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "customer_phone",
            columnDefinition = "TEXT"
    )
    private String customerPhone;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name = "dob",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDateTime dob;

    @Column(
            name ="gender",
            columnDefinition = "TEXT"
    )
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(
            mappedBy = "customer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private CustomerIdCard customerIdCard;


    /*@OneToMany(
            mappedBy = "customer",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    private List<Order> orders = new ArrayList<>();
*/


    public Customer(Long customerId,
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

    public Customer(String customerName,
                    String email,
                    String customerPhone,
                    String address,
                    LocalDateTime dob,
                    Gender gender) {
        this.customerName = customerName;
        this.email = email;
        this.customerPhone = customerPhone;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public Customer() {
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

    public void setCustomerIdCard(CustomerIdCard customerIdCard) {
        this.customerIdCard = customerIdCard;
    }
/*
    public List<Order> getOrders() {
        return orders;
    }
    */

    @Override
    public String toString() {
        return "Customer{" +
                "costumer_id=" + customerId +
                ", customer_name='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && Objects.equals(email, customer.email) && Objects.equals(customerPhone, customer.customerPhone) && Objects.equals(address, customer.address) && Objects.equals(dob, customer.dob) && gender == customer.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, email, customerPhone, address, dob, gender);
    }

}
