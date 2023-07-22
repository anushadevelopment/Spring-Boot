package com.cancodelah.customer.service.service;

import com.cancodelah.customer.service.dto.CustomerDto;
import com.cancodelah.customer.service.dto.CustomerMapper;
import com.cancodelah.customer.service.entity.Customer;
import com.cancodelah.customer.service.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Log4j2
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerMapper mapper;
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        Long customer_id = customer.getCustomerId();
        // System.out.println("CustomerID : " + customer_id);
        if (customerRepository.findByCustomerId(customer_id) != null) {
            customerRepository.updateCustomerById(customer_id, customer.getCustomerFirstName(), customer.getCustomerLastName(),
                    customer.getCustomerDob(), customer.getCustomerCountry(), customer.getCustomerAddress());
        }
    }

    public void updateCustomerDto (CustomerDto customerDto){
        log.info("Inside update Customer DTO Class");
        Customer mycustomer = customerRepository.findByCustomerId(customerDto.getCustomerId());
        log.info("customerDTO", customerDto);
        log.info("Customer", mycustomer);
        System.out.println("customer: " +mycustomer);
        System.out.println("customerDto: " +customerDto);
        mapper.updateCustomerFromDto(customerDto, mycustomer);
        customerRepository.save(mycustomer);
    }

    @Transactional
    public void deleteCustomerById ( long customerId){
        if (customerRepository.findByCustomerId(customerId) != null) {
            customerRepository.deleteByCustomerId(customerId);
        }
    }
}

