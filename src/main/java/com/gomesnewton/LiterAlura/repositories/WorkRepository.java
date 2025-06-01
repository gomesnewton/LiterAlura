package com.gomesnewton.LiterAlura.repositories;

import com.gomesnewton.LiterAlura.models.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
    List<Work> findWorkByTitle(String title);
}
