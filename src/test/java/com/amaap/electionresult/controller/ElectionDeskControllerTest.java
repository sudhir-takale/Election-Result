package com.amaap.electionresult.controller;

import com.amaap.electionresult.TestBase;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElectionDeskControllerTest extends TestBase {

    @Inject
    ElectionDeskController electionDeskController;

    @Test
    public void testMyServiceInjected() {
        assertNotNull(electionDeskController, "MyService should be injected by Guice");
    }

    @Test
    void shouldBeAbleToProcessInputFile() throws InvalidPartyCodeException, InvalidConstituencyFoundException {
        // arrange
        String filePath = "D:\\Tasks\\Election-Result\\src\\main\\java\\Resource\\ElectionData.txt";
        Response expected = new Response(HttpStatus.OK, "File processed successfully");

        // act
        Response actual = electionDeskController.processFile (filePath);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadResponseIfFilePathIsEmpty() throws InvalidPartyCodeException, InvalidConstituencyFoundException {
        // arrange
        String filePath = "";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Error in file processing");

        // act
        Response actual = electionDeskController.processFile(filePath);

        // assert
        assertEquals(expected, actual);
    }


}
