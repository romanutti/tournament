package com.example.tournament.application.listener;

import com.example.tournament.application.event.MatchOrganizedEvent;
import com.example.tournament.domain.model.Match;
import com.example.tournament.domain.model.Tournament;
import com.example.tournament.domain.repository.MatchRepository;
import com.example.tournament.domain.repository.TournamentRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MatchOrganizedEventListener {
    private final TournamentRepository tournamentRepository;
    private final MatchRepository matchRepository;

    public MatchOrganizedEventListener(TournamentRepository tournamentRepository, MatchRepository matchRepository) {
        this.tournamentRepository = tournamentRepository;
        this.matchRepository = matchRepository;
    }

    @EventListener
    public void handleMatchOrganized(MatchOrganizedEvent event) {
        Match match = new Match(null, event.participants());
        matchRepository.save(match);

        Tournament tournament = tournamentRepository.findById(event.tournamentId());
        tournament.addMatch(match.getId());
        tournamentRepository.save(tournament);
    }
}
