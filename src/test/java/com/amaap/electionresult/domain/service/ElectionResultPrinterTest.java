package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.ElectionWinnerDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.amaap.electionresult.domain.model.ElectionResultDTO;
import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.Party;

public class ElectionResultPrinterTest {
    @Test
    void shouldReturnWinnerPartyOfConstituency() {
        // Arrange
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Constituency constituency = new Constituency("Pune");
        Party expectedWinner = new Party("INC", "Indian National Congress");
        ElectionWinnerDTO winnerDTO = new ElectionWinnerDTO(expectedWinner, 445);
        electionResultDTO.getWinners().put(constituency, winnerDTO);
        // Act
        Party actualWinner = ElectionResultPrinter.getWinnerOfConstituency(electionResultDTO, constituency);
        // Assert
        assertEquals(expectedWinner, actualWinner);
    }


}
