package com.amaap.electionresult.service;

import com.amaap.electionresult.TestBase;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.google.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectionResultServiceTest extends TestBase {
    @Inject
    ElectionResultService electionResultService;

    @Test
    void shouldBeAbleToCrateANewElectionResult() {
        // arrange
        String constituencyName = "pune";
        int voteCount = 345;
        Map<Party, Integer> party = new HashMap<>();
        Party p = new Party("INC", "Indian national Congress");
        party.put(p, voteCount);
        ElectionResult expected = new ElectionResult(constituencyName, party);

        // act
        ElectionResult actual = electionResultService.create(constituencyName, "INC", voteCount);

        // assert
        assertEquals(expected, actual);
    }

}