package com.example.tournament.domain.model;

import java.util.List;

public class Match {
    private final Long id;
    private final List<Participant> participants;
    private MatchResult result;

    public Match(Long id, List<Participant> participants) {
        this.id = id;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public MatchResult getResult() {
        return result;
    }

    public void recordResult(MatchResult result) {
        if (this.result != null) {
            throw new IllegalStateException("Result has already been recorded.");
        }
        this.result = result;
    }
}

