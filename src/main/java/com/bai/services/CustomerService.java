package com.bai.services;

import com.bai.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer findById(int id);

    void deleteCustomer(int id);
}
