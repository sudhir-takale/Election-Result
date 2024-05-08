package com.amaap.electionresult.controller;

import com.amaap.electionresult.TestBase;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionResultControllerTest extends TestBase {

    @Inject
    ElectionResultController electionResultController;

    @Test
    void shouldBeAbleToCreateANewElectionResult() {
        // arrange
        String constituencyName = "pune";
        String partyCode = "INC";
        int voteCount = 345;
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = electionResultController.create(constituencyName, partyCode, voteCount);

        // assert
        assertEquals(expected, actual);
    }

}
