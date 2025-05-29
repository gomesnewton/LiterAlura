package com.gomesnewton.LiterAlura.repositories;

import com.gomesnewton.LiterAlura.models.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
}
