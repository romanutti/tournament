package com.example.tournament.application.event;

import com.example.tournament.domain.model.Participant;

import java.util.List;

public record MatchOrganizedEvent(Long tournamentId, List<Participant> participants) {
}

