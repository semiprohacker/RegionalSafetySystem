package com.project.regionsafetychecker.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.regionsafetychecker.entities.Locations;

public interface LocationRepo extends CrudRepository<Locations, Long> {

}
