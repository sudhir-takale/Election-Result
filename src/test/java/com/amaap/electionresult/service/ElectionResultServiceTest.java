package com.amaap.electionresult.service;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectionResultServiceTest {
    @Inject
    ElectionResultService electionResultService;
    @Inject
    PartyService partyService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        electionResultService = injector.getInstance(ElectionResultService.class);
        partyService = injector.getInstance(PartyService.class);
    }

    @Test
    void shouldBeAbleToCreateANewElectionResult() throws IllegalAccessException, InvalidPartyCodeException {
        // arrange
        String constituencyName = "pune";
        int voteCount = 345;
        Map<Party, Integer> party = new HashMap<>();
        Party p = new Party("INC", "Indian National Congress");
        party.put(p, voteCount);
        ElectionResult expected = new ElectionResult(constituencyName, party);
        partyService.create("INC");

        // act
        ElectionResult actual = electionResultService.create(constituencyName, "INC", voteCount);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetAllElectionResults() throws InvalidPartyCodeException, IllegalAccessException {
        // arrange
        String constituencyName = "pune";
        int voteCount = 345;
        int voteCount1 = 3445;
        Map<Party, Integer> party = new HashMap<>();
        Party p = new Party("INC", "Indian National Congress");
        Party p1 = new Party("AAP", "Aam Adami Party");
        party.put(p, voteCount);
        party.put(p1, voteCount1);
        partyService.create("INC");
        partyService.create("AAP");
        electionResultService.create(constituencyName, "INC", voteCount);
        electionResultService.create("Mumbai", "AAP", voteCount1);

        // act
        List<ElectionResult> electionResults = electionResultService.getElectionResults();

        // assert
        assertEquals(2, electionResults.size());

    }

}