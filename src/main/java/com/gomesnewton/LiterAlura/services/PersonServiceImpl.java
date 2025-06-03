package com.gomesnewton.LiterAlura.services;

import com.gomesnewton.LiterAlura.models.Person;
import com.gomesnewton.LiterAlura.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> fetchPersonList() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);
    }

    public List<Person> findByBirthYearAndDeathYear(Integer year) {
        return personRepository.findByBirthYearLessThanAndDeathYearGreaterThan(year, year);
    }
}
