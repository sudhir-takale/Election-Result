package org.amaap.task.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ElectionResultTest {

    @Test
    void shouldBeAbleToCalculateTheWinnerOfTheElection() {

        Map<String, Integer> votes = new HashMap<>();
        votes.put("BJP", 1233);
        votes.put("INC", 34543);
        votes.put("NCP", 345);
        votes.put("CPI", 3454);

        ElectionResult electionResult = new ElectionResult("Bangalore", votes);
        String winner = electionResult.getWinnerOfTheElection();
        Assertions.assertEquals("INC", winner);

    }

    @Test
    void shouldBeAbleToGiveFullOfWinningParty() {

        Map<String, Integer> votes = new HashMap<>();
        votes.put("BJP", 1233);
        votes.put("INC", 34543);
        votes.put("NCP", 345);
        votes.put("CPI", 3454);

        ElectionResult electionResult = new ElectionResult("Bangalore", votes);
        String winner = electionResult.getWinnerOfTheElection();

        String fullNameOfParty = electionResult.getFullNameOfParty(winner);
        Assertions.assertEquals("Indian National Congress", fullNameOfParty);
    }

    @Test
    void shouldAbleToGetConstituencyName() {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("BJP", 1233);
        votes.put("INC", 34543);
        votes.put("NCP", 345);
        votes.put("CPI", 3454);

        ElectionResult electionResult = new ElectionResult("Bangalore", votes);
        String constituencyName = electionResult.getConstituencyName();
        Assertions.assertEquals("Bangalore", constituencyName);


    }

}