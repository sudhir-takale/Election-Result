package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.google.inject.Inject;

public class ConstituencyController {

    private final ConstituencyService constituencyService;

    @Inject
    public ConstituencyController(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }

    public Response create(String name) {
        try {
            constituencyService.create(name);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidConstituencyFoundException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }


    }
}
