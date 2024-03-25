package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionResultProcessor {

    public ElectionResultDTO processElectionResults(List<ElectionResult> electionResults) {
        int percentage = 0, sumOfVotes = 0, totalVotes = 0;
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Map<Constituency, ElectionWinnerDTO> winners = new HashMap<>();
        for (ElectionResult result : electionResults) {
            sumOfVotes = result.getPartyVotes().values().stream().mapToInt(Integer::intValue).sum();
            Constituency constituency = result.getConstituency();
            Party winnerParty = calculateWinner(result.getPartyVotes());
            totalVotes = calculateTotalVotes(result.getPartyVotes());
            ElectionWinnerDTO winnerDTO = new ElectionWinnerDTO(winnerParty, totalVotes);
            winners.put(constituency, winnerDTO);
        }
        electionResultDTO.setWinners(winners);
        percentage = (totalVotes / sumOfVotes) * 100;
        electionResultDTO.setPercentageVotes(percentage);
        return electionResultDTO;
    }

    public Party calculateWinner(Map<Party, Integer> partyVotes) {
        Party winner = null;
        int maxVotes = Integer.MIN_VALUE;
        int totalVotes = 0;

        for (Map.Entry<Party, Integer> entry : partyVotes.entrySet()) {
            totalVotes += entry.getValue();
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }

    public int calculateTotalVotes(Map<Party, Integer> partyVotes) {
        int totalVotes = 0;
        for (int votes : partyVotes.values()) {
            totalVotes += votes;
        }
        return totalVotes;
    }
}
