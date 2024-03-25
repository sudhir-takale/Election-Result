package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ElectionResultProcessorTest {

    private ElectionResultProcessor electionResultProcessor;

    @BeforeEach
    public void setUp() {
        electionResultProcessor = new ElectionResultProcessor();
    }

    @Test
    void shouldAbleToProcessElectionResult() {
//        Arrange
        List<ElectionResult> electionResults = new ArrayList<>();
        Constituency constituency = new Constituency("Test Constituency");
        Map<Party, Integer> partyVotes = new HashMap<>();
        partyVotes.put(new Party("BJP", "Bhartiya Janta Party"), 1000);
        partyVotes.put(new Party("INC", "Indian National Congress"), 800);
        ElectionResult electionResult = new ElectionResult(constituency, partyVotes);
        electionResults.add(electionResult);
//        Act
        ElectionResultDTO resultDTO = electionResultProcessor.processElectionResults(electionResults);
//        Assert
        assertEquals(1, resultDTO.getWinners().size());
        ElectionWinnerDTO winnerDTO = resultDTO.getWinners().get(constituency);
        assertEquals(new Party("BJP", "Bhartiya Janta Party"), winnerDTO.getWinnerParty());
        assertEquals(1800, winnerDTO.getTotalVotes());
    }

    @Test
    public void shouldBeAbleToCalculateWinnerOfConstituency() {
//        Arrange
        Map<Party, Integer> partyVotes = new HashMap<>();
        partyVotes.put(new Party("BJP", "Bhartiya Janta Party"), 1000);
        partyVotes.put(new Party("INC", "Indian National Congress"), 800);
        partyVotes.put(new Party("AAP", "Aam Aadmi Party"), 1200);
//        Act
        Party winner = electionResultProcessor.calculateWinner(partyVotes);
//        Assert
        assertEquals(new Party("AAP", "Aam Aadmi Party"), winner);
    }

    @Test
    public void shouldBeAbleToCalculateTotalVotes() {
//        Arrange
        Map<Party, Integer> partyVotes = new HashMap<>();
        partyVotes.put(new Party("BJP", "Bhartiya Janta Party"), 1000);
        partyVotes.put(new Party("INC", "Indian National Congress"), 800);
        partyVotes.put(new Party("AAP", "Aam Aadmi Party"), 1200);
//        Act
        int totalVotes = electionResultProcessor.calculateTotalVotes(partyVotes);
//        Assert
        assertEquals(3000, totalVotes);
    }
}
