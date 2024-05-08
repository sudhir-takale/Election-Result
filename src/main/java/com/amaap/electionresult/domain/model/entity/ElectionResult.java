package com.amaap.electionresult.domain.model.entity;

import java.util.Map;
import java.util.Objects;

public class ElectionResult {

    private int id;
    private String constituencyName;
    private Map<Party, Integer> party;


    public ElectionResult(String constituencyName, Map<Party, Integer> party) {
        this.constituencyName = constituencyName;
        this.party = party;
    }

    public void setId(int id) {
        this.id = id;

    }

    public Map<Party, Integer> getParty() {
        return party;
    }

    public int getId() {
        return id;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectionResult that = (ElectionResult) o;
        return Objects.equals(constituencyName, that.constituencyName) && Objects.equals(party, that.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constituencyName, party);
    }
}
