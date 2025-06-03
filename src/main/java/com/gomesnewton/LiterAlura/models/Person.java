package com.gomesnewton.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="persons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    @Id @GeneratedValue private Long person_id;

    private String name;

    @JsonAlias("birth_year")
    private Integer birthYear;

    @JsonAlias("death_year")
    private Integer deathYear;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Work> works;

    public Person() {}

    public Person(Long personid, String name, Integer birthYear, Integer deathYear, Set<Work> works) {
        this.person_id = personid;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
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
        StringBuilder sb = new StringBuilder("Author { ");
        sb.append(" name: ").append(name);
        sb.append(", birth_year: ").append(birthYear);
        sb.append(", death_year: ").append(deathYear);
        sb.append(" }");
        return sb.toString();
    }
}