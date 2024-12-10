package com.project.regionsafetychecker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.regionsafetychecker.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
