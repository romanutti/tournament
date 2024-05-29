package com.example.tournament.application.listener;

import com.example.tournament.application.event.MatchOrganizedEvent;
import com.example.tournament.domain.model.Tournament;
import com.example.tournament.domain.repository.TournamentRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MatchOrganizedEventListener {
    private final TournamentRepository tournamentRepository;

    public MatchOrganizedEventListener(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @EventListener
    public void handleMatchOrganized(MatchOrganizedEvent event) {

        Tournament tournament = tournamentRepository.findById(event.tournamentId());
        tournament.addMatch(event.matchId());
        tournamentRepository.save(tournament);
    }
}
