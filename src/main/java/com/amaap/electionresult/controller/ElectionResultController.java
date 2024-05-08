package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.ElectionResultService;
import com.google.inject.Inject;

public class ElectionResultController {

    private final ElectionResultService electionResultService;

    @Inject
    public ElectionResultController(ElectionResultService electionResultService) {
        this.electionResultService = electionResultService;
    }

    public Response create(String constituencyName, String partyCode, int voteCount) throws IllegalAccessException {
        try {
            electionResultService.create(constituencyName, partyCode, voteCount);
            return new Response(HttpStatus.OK, "success");
        } catch (IllegalArgumentException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }
    }
}
