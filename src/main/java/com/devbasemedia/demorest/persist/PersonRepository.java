package com.devbasemedia.demorest.persist;

import com.devbasemedia.demorest.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByFirstName(String firstName);
}
