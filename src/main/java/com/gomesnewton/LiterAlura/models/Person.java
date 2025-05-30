package com.gomesnewton.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="persons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    @Id
    @GeneratedValue
    private Long person_id;
    private String name;
    private Integer birth_year;
    private Integer death_year;
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Work> works;

    public Person() {}

    public Person(Long personid, String name, Integer birth_year, Integer death_year, Set<Work> works) {
        this.person_id = personid;
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
        this.works = works;
    }

    public Long getId() {
        return person_id;
    }

    public void setId(Long id) {
        this.person_id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "%s, %d - %d".formatted(name, birth_year, death_year);
    }
}