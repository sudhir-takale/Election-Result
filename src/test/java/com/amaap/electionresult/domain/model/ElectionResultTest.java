package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ElectionResultTest {

    @Test
    public void testConstructorWithNonNullPartyVotes() {
//        Arrange
        Constituency constituency = new Constituency("Test Constituency");
        Map<Party, Integer> partyVotes = new HashMap<>();
        partyVotes.put(new Party("INC", "Indian National Congress"), 100);
        partyVotes.put(new Party("BJP", "Bhartiya Janta Party"), 200);
//        Act
        ElectionResult electionResult = new ElectionResult(constituency, partyVotes);
//        Assert
        assertEquals(constituency, electionResult.getConstituency());
        assertEquals(partyVotes, electionResult.getPartyVotes());
    }

    @Test
    public void testConstructorWithNullPartyVotes() {
        //Arrange
        Constituency constituency = new Constituency("Pune");
//      Act
        ElectionResult electionResult = new ElectionResult(constituency, null);
        // Assert
        assertEquals(constituency, electionResult.getConstituency());
        assertEquals(new HashMap<Party, Integer>(), electionResult.getPartyVotes());
    }

    @Test
    public void testSetterMethods() {
        // Arrange
        Constituency constituency = new Constituency("Pune");
        Map<Party, Integer> partyVotes = new HashMap<>();
        partyVotes.put(new Party("INC", "Indian National Congress"), 100);
        partyVotes.put(new Party("BJP", "Bhartiya Janta Party"), 200);
        // Act
        ElectionResult electionResult = new ElectionResult(null, null);
        electionResult.setConstituency(constituency);
        electionResult.setPartyVotes(partyVotes);
        // Assert
        assertEquals(constituency, electionResult.getConstituency());
        assertEquals(partyVotes, electionResult.getPartyVotes());
    }
}
