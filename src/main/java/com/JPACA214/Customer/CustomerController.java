package com.JPACA214.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/Register")
    public String RegisterCustomer() {
        return "RegisterCustomer";
    }


    //requests
    @RequestMapping("/all")
    public ModelAndView getAllCustomers() {
        List<Customer> list= customerService.getAllCustomers();
        return new ModelAndView("CustomerList","customer", list);
    }


    @RequestMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable int id) {
        customerService.DeleteCustomer(id);
        return "redirect:/all";
    }

    @RequestMapping("/Edit/{id}")
    public String editCustomerById(@PathVariable int id, Model model) {
        Customer person = customerService.getCustomerById(id);
        model.addAttribute("customer", person);
        return "Editcustomer";
    }

    @PostMapping("/save")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.InsertCustomer(customer);
        return "redirect:/all";
    }

}
