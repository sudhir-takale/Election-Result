package com.amaap.electionresult.controller;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.service.dto.ElectionResultDto;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void shouldBeAbleToGetWinnerOfTheConstituency() throws IllegalAccessException {
        // arrange
        String constituencyName = "pune";
        String partyCode = "INC";
        int voteCount = 345;
        partyController.create("INC");
        partyController.create("BJP");
        electionResultController.create(constituencyName, partyCode, voteCount);
        electionResultController.create(constituencyName, "BJP", 12);

        // act
        Optional<ElectionResultDto> electionResult = electionResultController.getWinnerOfConstituency(constituencyName);
        ElectionResultDto electionResult1 = electionResult.get();

        // assert
        assertEquals("INC", electionResult1.partyCode);
    }


}
