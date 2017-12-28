package com.cbmatthews.springbootmysql;

import com.cbmatthews.springbootmysql.dao.CustomerDAO;
import com.cbmatthews.springbootmysql.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
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
            CustomerDAO dao = ctx.getBean(CustomerDAO.class);
            List<Customer> list = dao.listCustomers();
            Customer c = dao.getCustomer(1);
            if (c == null) {
                c = new Customer();
                c.setFirstName("firstName");
                c.setLastName("lastName");
                c.setCreatedDate(new Date());
                c.setModifiedDate(new Date());
                Customer saved = dao.saveCustomer(c, false);
                System.out.println("Id of saved record: " + saved.getId());

                Customer saved2 = dao.saveCustomer(c, true);
                System.out.println("Id of saved record: " + saved.getId());

            }
        };
    }
}
