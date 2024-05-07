package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.io.FileReaderService;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Inject;

public class ElectionDeskController {

    private final FileReaderService fileReaderService;

    @Inject
    public ElectionDeskController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public Response processFile(String filePath) throws InvalidPartyCodeException {
        try {
            boolean result = fileReaderService.readFile(filePath);
            return new Response(HttpStatus.OK, "File processed successfully");

        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST, "Error in file processing");
        }

    }

}
