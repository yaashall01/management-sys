package com.yaashall.controller;

import com.yaashall.dto.CustomerRequest;
import com.yaashall.dto.CustomerResponse;
import com.yaashall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    //get all customers
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getCustomers(){
        return customerService.getCustomers();
    }

    //get custumer by id
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody CustomerRequest customerRequest){ // @RequestBody: to map the json request to the object
        customerService.addCustomer(customerRequest);
    }

    //delete customer by id
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }

    //update customer by id
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(id, customerRequest);
    }







}
