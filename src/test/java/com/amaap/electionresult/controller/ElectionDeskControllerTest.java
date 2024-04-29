package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionDeskControllerTest {

    ElectionDeskController electionDeskController = new ElectionDeskController();

    @Test
    void shouldBeAbleToProcessInputFile() {
        // arrange
        String filePath = "D:\\Tasks\\Election-Result\\src\\main\\java\\Resource\\ElectionData.txt";
        Response expected = new Response(HttpStatus.OK, "File processed successfully");

        // act
        Response actual = electionDeskController.processFile(filePath);

        // assert
        assertEquals(expected, actual);
    }
}
