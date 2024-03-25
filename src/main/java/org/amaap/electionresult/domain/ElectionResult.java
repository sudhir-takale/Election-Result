package org.amaap.electionresult.domain;

import java.util.HashMap;
import java.util.Map;

public class ElectionResult {


    private static Map<String, String> partyNames = new HashMap<>();

    static {
        partyNames.put("BJP", "Bhartiya Janta Party");
        partyNames.put("INC", "Indian National Congress");
        partyNames.put("BSP", "Bahujan Samaj Party");
        partyNames.put("NCP", "Nationalist Party Of India");
        partyNames.put("IND", "Independent");
        partyNames.put("CPI", "Communist Party Of India");


    }

    private String location;
    private Map<String, Integer> partyVotes;


    public ElectionResult(String location, Map<String, Integer> partyVotes) {

        this.location = location;
        this.partyVotes = partyVotes;
    }

    public static String getFullNameOfParty(String winner) {

        return partyNames.get(winner);
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

    public String getLocation() {
        return location;
    }

    public String getConstituencyName() {

        return getLocation();
    }
}

