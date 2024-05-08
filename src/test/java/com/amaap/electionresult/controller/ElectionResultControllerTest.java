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

public class ElectionResultControllerTest {

    @Inject
    ElectionResultController electionResultController;
    @Inject
    PartyController partyController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        electionResultController = injector.getInstance(ElectionResultController.class);
        partyController = injector.getInstance(PartyController.class);
    }

    @Test
    void shouldBeAbleToCreateANewElectionResult() throws IllegalAccessException {
        // arrange
        String constituencyName = "pune";
        String partyCode = "INC";
        int voteCount = 345;
        Response expected = new Response(HttpStatus.OK, "success");
        partyController.create("INC");
        // act
        Response actual = electionResultController.create(constituencyName, partyCode, voteCount);

        // assert
        assertEquals(expected, actual);
    }

}
