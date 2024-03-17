package org.amaap.task.domain;

import java.util.Map;

public class ElectionResult {


    private String location;
    private Map<String, Integer> partyVotes;

    public ElectionResult(String location, Map<String, Integer> partyVotes) {

        this.location = location;
        this.partyVotes = partyVotes;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Integer> getPartyVotes() {
        return partyVotes;
    }
}
