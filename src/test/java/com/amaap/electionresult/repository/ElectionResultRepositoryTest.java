package com.amaap.electionresult.repository;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectionResultRepositoryTest {

    @Inject
    ElectionResultRepository electionResultRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        electionResultRepository = injector.getInstance(ElectionResultRepository.class);

    }


    @Test
    void shouldBeAbleToSaveElectionResult() {
        // arrange
        String name = "Pune";
        Party party = new Party("INC", "Indian national congress");
        Map<Party, Integer> partyCode = new HashMap<>();
        partyCode.put(party, 345);
        ElectionResult expected = new ElectionResult(name, partyCode);

        // act
        ElectionResult actual = electionResultRepository.save(expected);

        // assert
        assertEquals(expected, actual);

    }

}