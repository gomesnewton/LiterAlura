package com.gomesnewton.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchWorks {
    private Long count;
    private String next;
    private String previous;
    private List<Work> results;

    public SearchWorks() {}

    public SearchWorks(Long count, String next, String previous, List<Work> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Work> getResults() {
        return results;
    }

    public void setResults(List<Work> results) {
        this.results = results;
    }

    public Work getWork(int index) {
        return results.get(index);
    }

    public void displayResults() {
        for(int i = 0; i < results.size(); i++) {
            System.out.printf("%d. %s%n", i, results.get(i));
        }
    }
}
