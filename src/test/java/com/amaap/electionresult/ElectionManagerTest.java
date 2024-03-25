package com.amaap.electionresult;

import com.amaap.electionresult.domain.model.*;
import com.amaap.electionresult.domain.service.ElectionResultPrinter;
import com.amaap.electionresult.domain.service.ElectionResultProcessor;
import com.amaap.electionresult.io.DataFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ElectionManagerTest {
    @Mock
    private DataFileReader dataFileReaderMock;
    @Mock
    private ElectionResultProcessor electionResultProcessorMock;
    @InjectMocks
    private ElectionManager electionManager;


    @Test
    void shouldProcessElectionResultsFromFile() throws IOException {
//        Arrange
        List<ElectionResult> electionResults = new ArrayList<>();
        ElectionResultDTO expectedResultDTO = new ElectionResultDTO();
//        Act
        when(dataFileReaderMock.readResultsFromFile("D:\\Tasks\\Election-Result\\src\\main\\java\\org\\amaap\\electionresult\\ElectionData.txt")).thenReturn(electionResults);
        when(electionResultProcessorMock.processElectionResults(electionResults)).thenReturn(expectedResultDTO);
//        Assert
        ElectionResultDTO actualResultDTO = electionManager.processElectionResultsFromFile("D:\\Tasks\\Election-Result\\src\\main\\java\\org\\amaap\\electionresult\\ElectionData.txt");
        assertEquals(expectedResultDTO, actualResultDTO);
    }

    @Test
    void shouldHandleIOExceptionInProcessElectionResultsFromFile() throws IOException {
//        Arrange
        when(dataFileReaderMock.readResultsFromFile("invalidFilePath")).thenThrow(IOException.class);
//        Act
        ElectionResultDTO actualResultDTO = electionManager.processElectionResultsFromFile("invalidFilePath");
//        Assert
        assertEquals(null, actualResultDTO);
    }

    @Test
    void shouldHandleNullFilePathInProcessElectionResultsFromFile() throws IOException {
//        Arrange & act
        ElectionResultDTO actualResultDTO = electionManager.processElectionResultsFromFile(null);
//        Assert
        assertEquals(null, actualResultDTO);
    }

    @Test
    void shouldReturnWinnerOfTheConstituency() {
//        Arrange
        Constituency constituency = new Constituency("Pune");
        Party expectedWinnerParty = new Party("INC", "Dummy");
        int totalVotes = 1000;
        ElectionWinnerDTO winnerDTO = new ElectionWinnerDTO(expectedWinnerParty, totalVotes);
        ElectionResultDTO electionResultDTO = new ElectionResultDTO();
        Map<Constituency, ElectionWinnerDTO> winnersMap = new HashMap<>();
        winnersMap.put(constituency, winnerDTO);
        electionResultDTO.setWinners(winnersMap);
//       Act
        Party actualWinnerParty = ElectionResultPrinter.getWinnerOfConstituency(electionResultDTO, constituency);
//     Assert
        assertEquals(expectedWinnerParty, actualWinnerParty);
    }

    @Test
    void shouldReturnWinnerOfConstituency() {
        // Arrange
        ElectionResultDTO electionResultDTO = mock(ElectionResultDTO.class);
        Constituency constituency = new Constituency("Pune");
        Party expectedWinner = new Party("INC", "Indian National Congress");
        ElectionWinnerDTO winnerDTO = mock(ElectionWinnerDTO.class);
        Map<Constituency, ElectionWinnerDTO> winnersMap = new HashMap<>();
        winnersMap.put(constituency, winnerDTO);
        when(electionResultDTO.getWinners()).thenReturn(winnersMap);
        when(winnerDTO.getWinnerParty()).thenReturn(expectedWinner);
        // Act
        ElectionManager electionManager = new ElectionManager(null, null);
        Party actualWinner = electionManager.getWinnerOfConstituency(electionResultDTO, constituency);
        // Assert
        assertEquals(expectedWinner, actualWinner);
    }

}
