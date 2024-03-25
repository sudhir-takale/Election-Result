package com.amaap.electionresult.domain.model;

public class ElectionWinnerDTO {
    private Party winnerParty;
    private int totalVotes;

    public ElectionWinnerDTO(Party winnerParty, int totalVotes) {
        this.winnerParty = winnerParty;
        this.totalVotes = totalVotes;
    }

    public Party getWinnerParty() {
        return winnerParty;
    }

    public void setWinnerParty(Party winnerParty) {
        this.winnerParty = winnerParty;
    }


    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

}
