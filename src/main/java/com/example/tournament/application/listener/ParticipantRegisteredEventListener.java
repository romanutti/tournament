package com.example.tournament.application.listener;

import com.example.tournament.application.event.ParticipantRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ParticipantRegisteredEventListener {
    @EventListener
    public void handleParticipantRegistered(ParticipantRegisteredEvent event) {
        // Handle the event, e.g., notify participants
    }
}

