package com.anupam.springSecurity.repositories;

import com.anupam.springSecurity.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
    public void deleteByUserId(Long id);
}
