package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.service.dto.ElectionResultDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ElectionResultEvaluatorTest {

    @Test
    void shouldBeAbleToCreateInstance() {
        // arrange & act
        ElectionResultEvaluator electionResultEvaluator = new ElectionResultEvaluator();

        // assert
        assertNotNull(electionResultEvaluator);

    }

    @Test
    void shouldBeAbleToEvaluateWinnerOfTheConstituency() {
        // arrange
        Map<Party, Integer> party = new HashMap<>();
        party.put(new Party("INC", "Indian national Congress"), 34534);
        party.put(new Party("BJP", "Bharat Janta Party"), 534);
        ElectionResult electionResult = new ElectionResult("pune", party);

        // act
        Optional<ElectionResultDto> winner = ElectionResultEvaluator.getWinnerOfConstituency(List.of(electionResult));

        // assert
        assertEquals("Indian national Congress", winner.get().partyName);
        assertEquals(34534, winner.get().winnerVotes);
    }


}