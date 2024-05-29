package com.example.tournament.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private Long id;
    private String name;
    private List<Participant> participants;
    private List<Long> matchIds;
    private TournamentStatus status;

    public Tournament(Long id, String name) {
        this.id = id;
        this.name = name;
        this.participants = new ArrayList<>();
        this.matchIds = new ArrayList<>();
        this.status = TournamentStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Long> getMatchIds() {
        return matchIds;
    }

    public TournamentStatus getStatus() {
        return status;
    }

    public void registerParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public void addMatch(Long matchId) {
        this.matchIds.add(matchId);
    }

    public void finalizeTournament(String winner) {
        if (status == TournamentStatus.COMPLETED) {
            throw new IllegalStateException("Tournament has already been finalized.");
        }
        this.status = TournamentStatus.COMPLETED;
        // Set the winner in some manner, e.g., a field or a dedicated method.
    }
}
