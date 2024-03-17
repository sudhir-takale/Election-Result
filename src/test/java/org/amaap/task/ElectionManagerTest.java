package org.amaap.task;

import org.amaap.task.data.DataFileReader;
import org.amaap.task.domain.ElectionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ElectionManagerTest {


    @InjectMocks

    ElectionManager electionManager;
    @Mock

    private DataFileReader dataFileReader;

    @Test
    void shouldBeAbleToReadFromFile() {

        when(dataFileReader.processFile("Dummy Path")).thenReturn(new ElectionResult());

        ElectionResult electionResult = electionManager.readDataFromFile();

        Assertions.assertNotNull(electionResult);
    }


}
