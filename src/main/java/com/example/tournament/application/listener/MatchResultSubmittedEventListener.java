package com.example.tournament.application.listener;

import com.example.tournament.application.event.MatchResultSubmittedEvent;
import com.example.tournament.domain.repository.MatchRepository;
import com.example.tournament.domain.model.Match;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MatchResultSubmittedEventListener {
    private final MatchRepository matchRepository;

    public MatchResultSubmittedEventListener(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @EventListener
    public void handleMatchResultSubmitted(MatchResultSubmittedEvent event) {
        Match match = matchRepository.getMatchById(event.getMatchId());
        match.recordResult(event.getResult());
        matchRepository.save(match);
    }
}

