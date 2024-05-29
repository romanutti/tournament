package com.example.tournament.application.event;

public record ParticipantRegisteredEvent(Long tournamentId, Long participantId) {
}

