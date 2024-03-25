package com.amaap.electionresult.domain.model;

public class Constituency {

    private String name;

    public Constituency(String name) {
        if (!PartyNameValidator.isValidConstituency(name)) {
            throw new IllegalArgumentException("Invalid party code: " + name);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
