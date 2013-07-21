package com.realtech.cloudschool.collaboration.infrastructure.persistence;


import com.realtech.cloudschool.collaboration.domain.model.LearningGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface LearningGroupRepository extends CrudRepository<LearningGroup, Long> {
    Page<LearningGroup> findByName(String name, Pageable pageable);
}
