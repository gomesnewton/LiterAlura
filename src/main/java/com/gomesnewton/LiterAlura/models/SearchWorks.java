package com.gomesnewton.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchWorks {
    private long count;
    private boolean next;
    private boolean previous;
    private List<Work> results;

    public SearchWorks() {}

    public SearchWorks(long count, boolean next, boolean previous, List<Work> results) {
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

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public List<Work> getResults() {
        return results;
    }

    public void setResults(List<Work> results) {
        this.results = results;
    }
}
