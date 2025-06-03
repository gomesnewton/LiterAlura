package com.gomesnewton.LiterAlura.repositories;

import com.gomesnewton.LiterAlura.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByBirthYearLessThanAndDeathYearGreaterThan(Integer initYear, Integer finalYear);
}
