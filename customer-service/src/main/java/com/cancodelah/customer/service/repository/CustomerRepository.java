package com.cancodelah.customer.service.repository;

import com.cancodelah.customer.service.dto.CustomerDto;
import com.cancodelah.customer.service.entity.Customer;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerId(Long customerId);
    void deleteByCustomerId(long customerId);

    // This method to update the inputted values and empty/null all other fields
    @Modifying
    @Query("update Customer c set c.customerLastName = :lastname, c.customerFirstName = :firstname, c.customerDob = :dob, c.customerCountry = :country, c.customerAddress = :address where customerId = :id" )
    void updateCustomerById(long id, String firstname, String lastname, Date dob, String country, String address);


//    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
//    void setUserInfoById(String firstname, String lastname, Integer userId);
//
//    @Query("select a from Author a where (a.authorFirstName = :name)"
//            +" or (a.authorLastName = :name)")
//
//    @Modifying
//    @Query("update Customer u set u.phone = :phone where u.id = :id")
//    void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);
}
