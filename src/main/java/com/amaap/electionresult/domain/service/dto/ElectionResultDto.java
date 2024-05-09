package com.amaap.electionresult.domain.service.dto;

public class ElectionResultDto {
    public String partyCode;
    public String partyName;
    public int winnerVotes;

    public ElectionResultDto(String partyCode, String partyName, int winningVotes) {
        this.partyName = partyName;
        this.partyCode = partyCode;
        this.winnerVotes = winningVotes;
    }
}
