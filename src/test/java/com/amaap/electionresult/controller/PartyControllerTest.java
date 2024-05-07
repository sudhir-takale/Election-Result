package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyControllerTest {
    PartyController partyController = new PartyController();

    @Test
    void shouldBeAbleToCreateNewParty() {
        // arrange
        String partyCode = "INC";
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = partyController.create(partyCode);

        // assert
        assertEquals(expected, actual);

    }


}
