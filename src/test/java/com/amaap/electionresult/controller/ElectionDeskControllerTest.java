package com.amaap.electionresult.controller;

import com.amaap.electionresult.ElectionModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.io.FileReaderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@GuiceModule(ElectionModule.class)
public class ElectionDeskControllerTest {

    ElectionDeskController electionDeskController = new ElectionDeskController(new FileReaderService());

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
      @Test
    void shouldReturnBadResponseIfFilePathIsEmpty() {
        // arrange
        String filePath = "";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Error in file processing");

        // act
        Response actual = electionDeskController.processFile(filePath);

        // assert
        assertEquals(expected, actual);
    }


}
