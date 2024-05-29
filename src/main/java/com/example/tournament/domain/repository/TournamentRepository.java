package com.example.tournament.domain.repository;

import com.example.tournament.domain.model.Tournament;

public interface TournamentRepository {
    Tournament findById(Long id);
    void save(Tournament tournament);
}