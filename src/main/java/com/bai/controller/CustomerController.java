package com.bai.controller;

import com.bai.dao.CustomerDao;
import com.bai.entity.Customer;
import com.bai.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    private String showCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "tracker/index";
    }

    @GetMapping("/showAddForm")
    private String addCustomer(Model model) {

        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "tracker/form";
    }

    @PostMapping("/saveCustomer")
    private String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save customer using service
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }


}
