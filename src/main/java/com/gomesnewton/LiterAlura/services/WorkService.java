package com.gomesnewton.LiterAlura.services;

import java.util.List;

import com.gomesnewton.LiterAlura.models.Work;

public interface WorkService {
    // Save operation
    Work saveWork(Work work);

    // Read operation
    List<Work> fetchWorkList();

    // Update operation
    Work updateWork(Work department, Long workId);

    // Delete operation
    void deleteWorkById(Long workId);
}
