package com.devbasemedia.demorest.rest;

import com.devbasemedia.demorest.domain.Country;
import com.devbasemedia.demorest.domain.Education;
import com.devbasemedia.demorest.domain.Person;
import com.devbasemedia.demorest.domain.State;
import com.devbasemedia.demorest.persist.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(value="/api")
public class PersonRest {
    @Autowired
    private PersonRepository repo;

    public PersonRepository getRepo() {
        return repo;
    }

    public void setRepo(PersonRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method=RequestMethod.GET, value="/person")
    public Person getPerson(@RequestParam(value="firstName", required = false) String firstName) throws ParseException {
        if (firstName == null) {
            firstName = "Bart";
        }

        return repo.findByFirstName(firstName);
    }

    @RequestMapping(method=RequestMethod.POST, value="/person")
    public Person savePerson(@RequestBody Person person) throws ParseException {
        /*if (person == null) {
            throw new ParseException("No person provided");
        }*/

        repo.deleteByFirstName(person.getFirstName());
        Person ret = repo.save(person);

        return ret;
    }
}
