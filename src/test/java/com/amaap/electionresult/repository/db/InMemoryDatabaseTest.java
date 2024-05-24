package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryDatabaseTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToSaveNewParty() {
        // arrange
        Party expected = new Party("INC", "Indian National Congress");

        // act
        Party actual = inMemoryDatabase.save(expected);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToGetPartyByPartyCode() {
        // arrange
        inMemoryDatabase.save(new Party("INC", "Indian National Congress"));

        // act
        Party actual = inMemoryDatabase.getBy("INC");

        // assert
        assertEquals("Indian National Congress", actual.getName());
        assertEquals("INC", actual.getCode());
    }

    @Test
    void shouldBeAbleToAddConstituencyInDatabase() {
        // arrange
        Constituency constituency = new Constituency("Pune");

        // act
        Constituency actual = inMemoryDatabase.insert(constituency);

        // assert
        assertEquals(constituency, actual);

    }

    @Test
    void shouldBeAbleToCheckForConstituency() {
        // arrange
        String name = "Pune";
        inMemoryDatabase.insert(new Constituency("pune"));

        // act
        boolean check = inMemoryDatabase.check(name);

        // assert
        assertTrue(check);
    }

    @Test
    void shouldBeAbleToSaveElectionResult() {
        // arrange
        Map<Party, Integer> party = new HashMap<>();
        party.put(new Party("INC", "Indian national Congress"), 34534);
        ElectionResult electionResult = new ElectionResult("pune", party);

        // act
        ElectionResult electionResult1 = inMemoryDatabase.saveResult(electionResult);

        // assert
        assertEquals(electionResult, electionResult1);
    }

    @Test
    void shouldBeAbleToGetAllElectionResult() {
        // arrange
        Map<Party, Integer> party = new HashMap<>();
        party.put(new Party("INC", "Indian national Congress"), 34534);
        ElectionResult electionResult = new ElectionResult("pune", party);
        inMemoryDatabase.saveResult(electionResult);

        // act
        List<ElectionResult> electionResults = inMemoryDatabase.getElectionResults();

        // assert
        assertEquals(1, electionResults.size());
    }
}