package com.cancodelah.customer.service.controller;

import com.cancodelah.customer.service.dto.CustomerDto;
import com.cancodelah.customer.service.entity.Customer;
import com.cancodelah.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long customerId){
        return customerService.findByCustomerId(customerId);
    }

    @PostMapping("/updatecustomer")
    public void updateCustomer(@RequestBody Customer customer){
         customerService.updateCustomer(customer);
    }
    @PostMapping("/update-customerdto")
    public void updateCustomerDto(@RequestBody CustomerDto customerDto){
        customerService.updateCustomerDto(customerDto);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomerById(@PathVariable("id") long customerId){
        customerService.deleteCustomerById(customerId);
    }


}
