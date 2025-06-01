package com.gomesnewton.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Work {
    @Id
    private Long work_id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "work_author", joinColumns = @JoinColumn(name = "work_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> authors;
    @ElementCollection
    private Set<String> languages;
    private Long download_count;

    public Work() {
    }

    public Work(Long work_id, String title, Set<Person> authors, Set<String> languages, Long download_count) {
        this.work_id = work_id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.download_count = download_count;
    }

    public Long getId() {
        return work_id;
    }

    public void setId(Long id) {
        this.work_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Long download_count) {
        this.download_count = download_count;
    }

    public Long getWork_id() {
        return work_id;
    }

    public void setWork_id(Long work_id) {
        this.work_id = work_id;
    }

    public Set<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Person> authors) {
        this.authors = authors;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book { ");
        sb.append("id: ").append(work_id);
        sb.append(", title: ").append(title);
        sb.append(", author: ").append(authors);
        sb.append(", languages: ").append(languages);
        sb.append(", download_count: ").append(download_count);
        sb.append(" }");
        return sb.toString();
    }
}
