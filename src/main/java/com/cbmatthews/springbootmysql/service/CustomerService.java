package com.cbmatthews.springbootmysql.service;

import com.cbmatthews.springbootmysql.jpa.Customer;

import java.util.List;

public interface CustomerService {
    public void deleteAllCustomers();

    public List<Customer> listCustomers();

    public Customer getCustomer(int id);

    public Customer saveCustomer(Customer c, boolean explode);

    public List<Customer> saveCustomers(List<Customer> customers, int explodeAfterSavingThisMany);
}
