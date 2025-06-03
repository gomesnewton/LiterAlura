package com.gomesnewton.LiterAlura.repositories;

import com.gomesnewton.LiterAlura.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query( value = "SELECT * FROM PERSONS WHERE BIRTH_YEAR < :year AND DEATH_YEAR > :year;",
            nativeQuery = true)
    List<Person> findByBirthAndDeathYear(Integer year);
}
