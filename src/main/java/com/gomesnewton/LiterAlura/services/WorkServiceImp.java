package com.gomesnewton.LiterAlura.services;

import com.gomesnewton.LiterAlura.models.Person;
import com.gomesnewton.LiterAlura.models.Work;
import com.gomesnewton.LiterAlura.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkServiceImp implements WorkService {

    @Autowired
    WorkRepository workRepository;

    @Override
    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public List<Work> fetchWorkList() {
        return (List<Work>) workRepository.findAll();
    }

    @Override
    public Work updateWork(Work work, Long workId) {
        Work workDB = workRepository.findById(workId).get();

        if (Objects.nonNull(work.getTitle()) && !"".equalsIgnoreCase(work.getTitle())) {
            workDB.setTitle(work.getTitle());
        }

        return workRepository.save(workDB);
    }

    @Override
    public void deleteWorkById(Long workId) {
        workRepository.deleteById(workId);
    }

    @Override
    public List<Work> findByLanguages(String language) {
        return workRepository.findByLanguagesContaining(language);
    }
}
