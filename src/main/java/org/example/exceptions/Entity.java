package org.example.exceptions;

public enum Entity {
    USER("User"),
    JOBROLE("JobRole");

    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return this.entity;
    }
}
