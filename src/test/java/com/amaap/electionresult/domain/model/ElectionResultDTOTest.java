package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectionResultDTOTest {


    @Test
    void shouldNotShowWinnerIfMapIsEmpty() {
        // Arrange
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Map<Constituency, ElectionWinnerDTO> expectedWinners = new HashMap<>();
        // Act
        electionResultDTO.setWinners(expectedWinners);
        Map<Constituency, ElectionWinnerDTO> actualWinners = electionResultDTO.getWinners();
        // Assert
        assertEquals(expectedWinners, actualWinners);
        Assertions.assertTrue(actualWinners.isEmpty());
    }


    @Test
    void shouldReturnWinnerOfConstituency() {
        // Arrange
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Map<Constituency, ElectionWinnerDTO> expectedWinners = new HashMap<>();
        Constituency constituency1 = new Constituency("Constituency 1");
        Constituency constituency2 = new Constituency("Constituency 2");
        ElectionWinnerDTO winnerDTO1 = new ElectionWinnerDTO(new Party("INC", "Name"), 1000);
        ElectionWinnerDTO winnerDTO2 = new ElectionWinnerDTO(new Party("BJP", "Party"), 800);
        expectedWinners.put(constituency1, winnerDTO1);
        expectedWinners.put(constituency2, winnerDTO2);
        // Act
        electionResultDTO.setWinners(expectedWinners);
        Map<Constituency, ElectionWinnerDTO> actualWinners = electionResultDTO.getWinners();
        // Assert
        assertEquals(expectedWinners, actualWinners);
    }

    @Test
    void shouldAbleToSetWinnerOfConstituency() {
        // Arrange
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Map<Constituency, ElectionWinnerDTO> expectedWinners = new HashMap<>();
        Constituency constituency = new Constituency("Constituency");
        ElectionWinnerDTO winnerDTO = new ElectionWinnerDTO(new Party("INC", "Indian National Congress"), 1000);
        expectedWinners.put(constituency, winnerDTO);
        // Act
        electionResultDTO.setWinners(expectedWinners);
        Map<Constituency, ElectionWinnerDTO> actualWinners = electionResultDTO.getWinners();
        // Assert
        assertEquals(expectedWinners, actualWinners);
    }
}
