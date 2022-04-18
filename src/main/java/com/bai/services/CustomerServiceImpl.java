package com.bai.services;

import com.bai.dao.CustomerDao;
import com.bai.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDao.getCustomers();
        return customers;
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {

        customerDao.saveCustomer(customer);
    }
}
