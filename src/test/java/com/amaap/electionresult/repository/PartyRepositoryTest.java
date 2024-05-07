package com.amaap.electionresult.repository;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.entity.Party;
import com.amaap.electionresult.repository.impl.InMemoryPartyRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartyRepositoryTest {

    @Inject
    PartyRepository partyRepository;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        partyRepository = injector.getInstance(InMemoryPartyRepository.class);

    }


    @Test
    void shouldBeAbleToSavePartyIntoDatabase() {
        // arrange
        String partyCode = "INC";
        String partyName = "Indian National Congress";
        Party expected = new Party(partyCode, partyName);

        // act
        Party actual = partyRepository.save(expected);

        // assert
        assertEquals(expected, actual);
    }

}