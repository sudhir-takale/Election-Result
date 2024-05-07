package com.amaap.electionresult.domain.entity;

import java.util.Objects;

public class Party {

    private final String code;
    private final String name;
    private int id;

    public Party(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(code, party.code) && Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    public void setId(int id) {
        this.id = id;
    }
}
