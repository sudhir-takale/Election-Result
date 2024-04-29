package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;

public class ElectionDeskController {
    public Response processFile(String filePath) {
        return new Response(HttpStatus.OK, "File processed successfully");

    }
}
