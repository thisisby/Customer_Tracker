package com.bai.dao;

import com.bai.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    final SessionFactory sessionFactory;

    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Transactional
    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

//    public List<Customer> getCustomers() {
//        List<Customer> list = null;
//        try {
//            list = new ArrayList<Customer>();
//            Query<Customer> query = sessionFactory.getCurrentSession().createQuery("from Customer");
//            list = query.getResultList();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
