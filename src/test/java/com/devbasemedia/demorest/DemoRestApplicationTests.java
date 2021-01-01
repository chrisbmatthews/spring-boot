package com.devbasemedia.demorest;

import com.devbasemedia.demorest.domain.Country;
import com.devbasemedia.demorest.domain.Education;
import com.devbasemedia.demorest.domain.Person;
import com.devbasemedia.demorest.domain.State;
import com.devbasemedia.demorest.persist.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
public class DemoRestApplicationTests {
	@Autowired
	private PersonRepository repo;

	private static DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

	public PersonRepository getRepo() {
		return repo;
	}

	public void setRepo(PersonRepository repo) {
		this.repo = repo;
	}

	/**
	 * Test set to Ignore for now, as I don't want to atempt to connect to a real db on build
	 * comment out the @Ignore if you'd like to run this yourself.
	 * @throws Exception
	 */
	@Test
    //@Ignore
	public void persistPerson() throws Exception {
		Person person = this.createPerson("Homer");
		repo.save(person);

	}

	private Person createPerson(String firstName) throws ParseException {
		Person ret = new Person();

		if (firstName != null) {
			ret.setFirstName(firstName);
		} else {
			ret.setFirstName("Bart");
		}
		ret.setLastName("Simpson");

		ret.getAddress().setCivicNumber(123);
		ret.getAddress().setStreetName("Fake st");
		ret.getAddress().setCity("Springfield");
		ret.getAddress().setState(State.OR);
		ret.getAddress().setZipCode("12345");
		ret.getAddress().setCountry(Country.USA);

		Education edu1 = new Education();
		edu1.setInstitution("School 1");
		edu1.setDateEnrolled(sdf.parse("2000-01-01"));
		edu1.setDateCompleted(sdf.parse("2004-01-01"));
		edu1.getAddress().setCivicNumber(444);
		edu1.getAddress().setStreetName("University ave");
		edu1.getAddress().setCity("MyCity");
		edu1.getAddress().setState(State.CA);
		edu1.getAddress().setZipCode("56789");
		edu1.getAddress().setCountry(Country.USA);

		ret.getEducationList().add(edu1);

		return ret;
	}

}
