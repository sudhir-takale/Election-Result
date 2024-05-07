package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;

public class PartyController {
    public Response create(String partyCode) {
        return new Response(HttpStatus.OK, "success");
    }
}
