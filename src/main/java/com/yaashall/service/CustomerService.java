package com.yaashall.service;

import com.yaashall.entity.Customer;
import com.yaashall.repository.CustomerRepository;
import com.yaashall.dto.CustomerRequest;
import com.yaashall.dto.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<CustomerResponse> getCustomers(){

        List<CustomerResponse> listOfCustomers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            CustomerResponse customerResponse = new CustomerResponse(customer);
            listOfCustomers.add(customerResponse);
        }
         return listOfCustomers;

    }

    public CustomerResponse getCustomerById(Long id){
        return new CustomerResponse(customerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Customer with id " + id + " does not exist")));
    }

    public void addCustomer(CustomerRequest customerRequest){
        Customer newCustomer = new Customer();

        newCustomer.setCustomerName(customerRequest.getCustomerName());
        newCustomer.setEmail(customerRequest.getEmail());
        newCustomer.setCustomerPhone(customerRequest.getCustomerPhone());
        newCustomer.setAddress(customerRequest.getAddress());
        newCustomer.setDob(customerRequest.getDob());
        newCustomer.setGender(customerRequest.getGender());

        customerRepository.save(newCustomer);
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest){

        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Customer with id " + id + " does not exist")
        );

        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setCustomerPhone(customerRequest.getCustomerPhone());
        customer.setAddress(customerRequest.getAddress());
        customer.setDob(customerRequest.getDob());
        customer.setGender(customerRequest.getGender());
        customer.setEmail(customerRequest.getEmail());

        return new CustomerResponse(customerRepository.save(customer));

    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
