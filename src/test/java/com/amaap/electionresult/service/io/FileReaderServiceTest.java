package com.amaap.electionresult.service.io;

import com.amaap.electionresult.TestBase;
import com.amaap.electionresult.service.io.exception.EmptyFilePathException;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderServiceTest extends TestBase {

    @Inject
    FileReaderService fileReaderService;

    @Test
    void shouldReturnTrueIfFileProcessedSuccessfully() throws EmptyFilePathException, IOException, InvalidPartyCodeException {
        // arrange
        String filePath = "D:\\Tasks\\Election-Result\\src\\main\\java\\Resource\\ElectionData.txt";

        // act
        boolean result = fileReaderService.readFile(filePath);

        // assert
        assertTrue(result);
    }


    @Test
    void shouldThrowExceptionIfFilePathIsEmpty() {
        // arrange
        String filePath = " ";

        // act & assert
        assertThrows(EmptyFilePathException.class, () -> fileReaderService.readFile(filePath));
    }

}