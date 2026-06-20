package com.anupam.springSecurity.repositories;

import com.anupam.springSecurity.entities.SessionEntityHomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepositoryHomework extends JpaRepository<SessionEntityHomeWork, Long> {
    void deleteByUserId(Long id);
}