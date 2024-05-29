package com.example.tournament.application.event;

import com.example.tournament.domain.model.MatchResult;

public class MatchResultSubmittedEvent {
    private final Long matchId;
    private final MatchResult result;

    public MatchResultSubmittedEvent(Long matchId, MatchResult result) {
        this.matchId = matchId;
        this.result = result;
    }

    public Long getMatchId() {
        return matchId;
    }

    public MatchResult getResult() {
        return result;
    }
}

