package com.amaap.electionresult.controller;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyControllerTest {

    @Inject
    PartyController partyController;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        partyController = injector.getInstance(PartyController.class);

    }

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