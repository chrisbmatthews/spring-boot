package com.cbmatthews.springbootmysql.service;

import com.cbmatthews.springbootmysql.dao.CustomerDAO;
import com.cbmatthews.springbootmysql.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO dao;

    @Override
    public List<Customer> listCustomers() {
        return dao.listCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return dao.getCustomer(id);
    }

    @Override
    public List<Customer> saveCustomers(List<Customer> customers, int explodeAfterSavingThisMany) {
        List<Customer> ret = new ArrayList<>();

        int savedSoFar = 0;
        for (Customer c : customers) {
            Customer saved = dao.saveCustomer(c, false);
            ret.add(saved);
            savedSoFar++;
            if (explodeAfterSavingThisMany > 0) {
                //we *do* want to explode after saving a certain amount...
                if (savedSoFar >= explodeAfterSavingThisMany) {
                    //force an explosion and hopefully a rollback!
                    throw new RuntimeException("exploded after saving " + savedSoFar + " customers");
                }
            }
        }
        return ret;
    }

    @Override
    public void deleteAllCustomers() {
        List<Customer> toDelete = this.listCustomers();
        for (Customer c : toDelete) {
            dao.deleteCustomer(c);
        }
    }

    @Override
    public Customer saveCustomer(Customer c, boolean explode) {
        return dao.saveCustomer(c, explode);
    }
}
