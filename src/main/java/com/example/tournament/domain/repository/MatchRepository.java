package com.example.tournament.domain.repository;

import com.example.tournament.domain.model.Match;

public interface MatchRepository {
    Match getMatchById(Long id);
    void save(Match match);
}
