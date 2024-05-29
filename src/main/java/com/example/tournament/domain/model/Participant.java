package com.example.tournament.domain.model;

public class Participant {
    private final Long id;
    private Name name;

    public Participant(Long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
