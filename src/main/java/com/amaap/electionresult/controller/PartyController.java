package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.PartyService;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Inject;

public class PartyController {

    private final PartyService partyService;

    @Inject
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    public Response create(String partyCode) {
        try {
            partyService.create(partyCode);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidPartyCodeException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }

    }
}
