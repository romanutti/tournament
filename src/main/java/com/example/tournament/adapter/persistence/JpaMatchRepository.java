package com.example.tournament.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMatchRepository extends JpaRepository<MatchEntity, Long> {
}
