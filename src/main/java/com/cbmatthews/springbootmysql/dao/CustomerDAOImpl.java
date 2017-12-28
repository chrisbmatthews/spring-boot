package com.cbmatthews.springbootmysql.dao;

import com.cbmatthews.springbootmysql.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Customer getCustomer(int id) {
        Customer ret = null;

        ret = this.entityManager.find(Customer.class, id);

        return ret;
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer c, boolean explode) {
        Customer ret = null;

        if (c != null) {
            ret = this.entityManager.merge(c);
        }

        if (explode) {
            throw new RuntimeException("forcing this transaction to roll back!");
        }


        return ret;
    }

    @Override
    public List<Customer> listCustomers() {
        return this.entityManager.createQuery("select c from Customer c").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
