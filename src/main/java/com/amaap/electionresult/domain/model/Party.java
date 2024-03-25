package com.amaap.electionresult.domain.model;

import java.util.Objects;

public class Party {

    private String code;
    private String name;

    public Party(String code, String name) {

        if (!PartyNameValidator.isValidParty(code)) {
            throw new IllegalArgumentException("Invalid party code: " + code);
        }
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}
