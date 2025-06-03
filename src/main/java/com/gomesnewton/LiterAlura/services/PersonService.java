package com.gomesnewton.LiterAlura.services;

import com.gomesnewton.LiterAlura.models.Person;

import java.util.List;

public interface PersonService {
    // Save operation
    Person savePerson(Person person);

    // Read operation
    List<Person> fetchPersonList();

    // Delete operation
    void deletePersonById(Long personId);

    List<Person> findByBirthYearAndDeathYear(Integer year);
}
