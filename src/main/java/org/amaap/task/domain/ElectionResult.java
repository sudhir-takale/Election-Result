package org.amaap.task.domain;

import java.util.HashMap;
import java.util.Map;

public class ElectionResult {


    private String location;
    private Map<String, Integer> partyVotes;

    public ElectionResult(String location, Map<String, Integer> partyVotes) {

        this.location = location;
        this.partyVotes = partyVotes;
    }

    public String getWinnerOfTheElection() {

        String winner = null;
        int maxVotes = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) {
            String party = entry.getKey();
            int votes = entry.getValue();

            if (votes > maxVotes) {
                maxVotes = votes;
                winner = party;
            }
        }

        return winner;
    }


}

