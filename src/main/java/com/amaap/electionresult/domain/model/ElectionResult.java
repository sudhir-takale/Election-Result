package com.amaap.electionresult.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ElectionResult {

    private Constituency constituency;
    private Map<Party, Integer> partyVotes;

    public ElectionResult(Constituency constituency, Map<Party, Integer> partyVotes) {
        this.constituency = constituency;
        this.partyVotes = partyVotes != null ? new HashMap<>(partyVotes) : new HashMap<>();
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    public Map<Party, Integer> getPartyVotes() {
        return partyVotes;
    }

    public void setPartyVotes(Map<Party, Integer> partyVotes) {
        this.partyVotes = partyVotes != null ? new HashMap<>(partyVotes) : new HashMap<>();
    }
}
