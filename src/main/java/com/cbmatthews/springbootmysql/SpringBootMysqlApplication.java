package com.cbmatthews.springbootmysql;

import com.cbmatthews.springbootmysql.jpa.Customer;
import com.cbmatthews.springbootmysql.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMysqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CustomerService service = ctx.getBean(CustomerService.class);

            //start with a clean slate...
            service.deleteAllCustomers();

            //verify that we have exactly 0 customers to start with...
            List<Customer> list = service.listCustomers();

            System.out.println("Customer count: " + list.size());

            Customer c1 = createDummyCustomer(1);
            Customer saved = service.saveCustomer(c1, false);
            System.out.println("Id of saved record: " + saved.getId());

            list = service.listCustomers();

            System.out.println("Customer count after saving 1: " + list.size());

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

            System.out.println("Customer count at the end (should be 1): " + list.size());
        };
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
