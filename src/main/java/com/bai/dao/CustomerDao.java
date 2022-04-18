package com.bai.dao;

import com.bai.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    public Customer findById(int id);

    void deleteCustomer(int id);
}
