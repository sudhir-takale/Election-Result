package com.amaap.electionresult.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ElectionResultDTO {
    private Map<Constituency, ElectionWinnerDTO> winners;
    private int percentageVotes;

    public ElectionResultDTO() {
        this.winners = new HashMap<>();
    }

    public int getPercentageVotes() {
        return percentageVotes;
    }

    public void setPercentageVotes(int percentageVotes) {
        this.percentageVotes = percentageVotes;
    }

    public Map<Constituency, ElectionWinnerDTO> getWinners() {
        return winners;
    }

    public void setWinners(Map<Constituency, ElectionWinnerDTO> winners) {
        this.winners = winners;
    }


}
