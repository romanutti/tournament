package com.example.tournament.adapter.persistence;

import com.example.tournament.domain.model.Match;
import com.example.tournament.domain.repository.MatchRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MatchRepositoryImpl implements MatchRepository {
    // private final JpaMatchRepository jpaMatchRepository;

    public MatchRepositoryImpl(
            // JpaMatchRepository jpaMatchRepository
    ) {
        // this.jpaMatchRepository = jpaMatchRepository;
    }

    @Override
    public Match getMatchById(Long id) {
        return null;
        // return jpaMatchRepository.findById(id)
        //         .map(this::toDomain)
        //         .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Override
    public void save(Match match) {
        // jpaMatchRepository.save(toEntity(match));
    }

    private Match toDomain(MatchEntity entity) {
        // convert MatchEntity to Match domain object
        return null;
    }

    private MatchEntity toEntity(Match match) {
        // convert Match domain object to MatchEntity
        return null;
    }
}
