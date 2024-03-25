package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionWinnerDTOTest {

    @Test
    void shouldCreateElectionWinnerDTO() {
        // Arrange
        Party party = new Party("INC", "Indian National Congress");
        int totalVotes = 1000;
        // Act
        ElectionWinnerDTO electionWinnerDTO = new ElectionWinnerDTO(party, totalVotes);
        // Assert
        assertEquals(party, electionWinnerDTO.getWinnerParty());
        assertEquals(totalVotes, electionWinnerDTO.getTotalVotes());
    }

    @Test
    void shouldSetWinnerParty() {
        // Arrange
        Party party = new Party("INC", "Indian National Congress");
        ElectionWinnerDTO electionWinnerDTO = new ElectionWinnerDTO(null, 0);
        // Act
        electionWinnerDTO.setWinnerParty(party);
        // Assert
        assertEquals(party, electionWinnerDTO.getWinnerParty());
    }

    @Test
    void shouldSetTotalVotes() {
        // Arrange
        int totalVotes = 1000;
        ElectionWinnerDTO electionWinnerDTO = new ElectionWinnerDTO(null, 0);
        // Act
        electionWinnerDTO.setTotalVotes(totalVotes);
        // Assert
        assertEquals(totalVotes, electionWinnerDTO.getTotalVotes());
    }
}
