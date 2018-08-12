package com.devbasemedia.demorest.rest;

import com.devbasemedia.demorest.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class PersonRest {

    @RequestMapping(method=RequestMethod.GET, value="/person")
    public Person getPerson(@RequestParam(value="firstName", required = false) String firstName) {
        Person ret = new Person();

        if (firstName != null) {
            ret.setFirstName(firstName);
        } else {
            ret.setFirstName("Bart");
        }
        ret.setLastName("Simpson");

        return ret;
    }
}
