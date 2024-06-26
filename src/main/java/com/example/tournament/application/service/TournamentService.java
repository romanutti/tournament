package com.example.tournament.application.service;

import com.example.tournament.application.event.MatchOrganizedEvent;
import com.example.tournament.application.event.ParticipantRegisteredEvent;
import com.example.tournament.domain.model.Match;
import com.example.tournament.domain.model.Participant;
import com.example.tournament.domain.model.Tournament;
import com.example.tournament.domain.repository.MatchRepository;
import com.example.tournament.domain.repository.TournamentRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final MatchRepository matchRepository;
    private final ApplicationEventPublisher eventPublisher;

    public TournamentService(TournamentRepository tournamentRepository, MatchRepository matchRepository, ApplicationEventPublisher eventPublisher) {
        this.tournamentRepository = tournamentRepository;
        this.matchRepository = matchRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Tournament createNewTournament(String name, List<Participant> participants) {
        Tournament tournament = new Tournament(null, name);
        participants.forEach(tournament::registerParticipant);
        tournamentRepository.save(tournament);

        participants.forEach(participant -> eventPublisher.publishEvent(new ParticipantRegisteredEvent(tournament.getId(), participant.getId())));

        return tournament;
    }

    @Transactional
    public void declareWinner(Long tournamentId, String winner) {
        Tournament tournament = tournamentRepository.findById(tournamentId);
        tournament.finalizeTournament(winner);
        tournamentRepository.save(tournament);
    }

    @Transactional
    public void organizeMatch(Long tournamentId, List<Participant> participants) {
        Match match = new Match(null, participants);
        matchRepository.save(match);

        eventPublisher.publishEvent(new MatchOrganizedEvent(tournamentId, match.getId()));
    }
}
