package com.bai.services;

import com.bai.dao.CustomerDao;
import com.bai.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> list() {
        List<Customer> list = customerDao.getCustomers();
        return list;
    }
}
