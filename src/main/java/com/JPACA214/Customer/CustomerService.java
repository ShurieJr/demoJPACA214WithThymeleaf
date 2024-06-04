package com.JPACA214.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public void InsertCustomer(Customer customer){
        repository.save(customer);
    }
    public void UpdateCustomer(Customer customer){
        repository.save(customer);
    }
    public void DeleteCustomer(int id){
        repository.deleteById(id);
    }
}
