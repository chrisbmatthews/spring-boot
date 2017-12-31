package com.cbmatthews.springbootmysql;

import com.cbmatthews.springbootmysql.jpa.Customer;
import com.cbmatthews.springbootmysql.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMysqlApplicationTests {
    @Autowired
    private CustomerService service;

    @Test
    public void testH2DatabaseTransactions() throws Exception {
        //start with a clean slate...
        service.deleteAllCustomers();

        //verify that we have exactly 0 customers to start with...
        List<Customer> list = service.listCustomers();

        assertEquals(0, list.size());

        Customer c1 = createDummyCustomer(1);
        Customer saved = service.saveCustomer(c1, false);

        list = service.listCustomers();

        assertEquals(1, list.size());

        List<Customer> toSave = new ArrayList<>();
        toSave.add(createDummyCustomer(2));
        toSave.add(createDummyCustomer(3));
        toSave.add(createDummyCustomer(4));

        //this should roll back...
        try {
            service.saveCustomers(toSave, 2);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        //we should still have exactly 1 customer in the database...
        list = service.listCustomers();

        assertEquals(1, list.size());

    }

    private Customer createDummyCustomer(int suffix) {
        Customer c = new Customer();
        c.setFirstName("firstName" + suffix);
        c.setLastName("lastName" + suffix);
        c.setCreatedDate(new Date());
        c.setModifiedDate(new Date());
        return c;
    }

}
