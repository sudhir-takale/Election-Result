package org.amaap.electionresult;

import org.amaap.electionresult.data.DataFileReader;
import org.amaap.electionresult.data.exception.EmptyFilePathException;
import org.amaap.electionresult.domain.ElectionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ElectionManagerTest {


    @InjectMocks

    ElectionManager electionManager;
    @Mock

    private DataFileReader dataFileReader;

    @Test
    void shouldBeAbleToReadFromFile() throws EmptyFilePathException, IOException {

        when(dataFileReader.processFile("D:\\Election Result\\src\\main\\java\\org\\amaap\\task\\ElectionData.txt")).thenReturn(new ElectionResult("Pune", new HashMap<>()));

        ElectionResult electionResult = electionManager.readDataFromFile();

        Assertions.assertNotNull(electionResult);
    }

    @Test
    void shouldBeAbleToShowTheWinnerOfTheElectionFromBangaloreRegion() throws EmptyFilePathException, IOException {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("BJP", 1233);
        votes.put("INC", 34543);
        votes.put("NCP", 345);
        votes.put("CPI", 3454);
        ElectionResult electionResult = new ElectionResult("Bangalore", votes);
        when(dataFileReader.processFile("D:\\Election Result\\src\\main\\java\\org\\amaap\\task\\ElectionData.txt")).thenReturn(electionResult);

        String winner = electionManager.showWinnerOfTheElection();
        Assertions.assertEquals("INC", winner);
    }

    @Test
    void shouldBeAbleToGetFullNameOfPartyWhichHasWinnerOfConstituency() throws EmptyFilePathException, IOException {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("BJP", 1233);
        votes.put("INC", 34543);
        votes.put("NCP", 345);
        votes.put("CPI", 3454);
        ElectionResult electionResult = new ElectionResult("Bangalore", votes);
        when(dataFileReader.processFile("D:\\Election Result\\src\\main\\java\\org\\amaap\\task\\ElectionData.txt")).thenReturn(electionResult);

        String winnerFullName = electionManager.getFullNameOfParty();
        Assertions.assertEquals("Indian National Congress", winnerFullName);
    }


}