package org.amaap.task;

import org.amaap.task.data.DataFileReader;
import org.amaap.task.data.exception.EmptyFilePathException;
import org.amaap.task.domain.ElectionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.HashMap;

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

        String winner = electionManager.showWinnerOfTheElection();
        Assertions.assertEquals("INC", winner);

    }

    @Test
    void shouldBeAbleToGetFullNameOfPartyWhichHasWinnerOfConstituency() throws EmptyFilePathException, IOException {

        String winner = electionManager.showWinnerOfTheElection();
        String winnerFullName = electionManager.getFullNameOfParty(winner);
        Assertions.assertEquals("Indian National Congress", winnerFullName);

    }

}
