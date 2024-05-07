package com.amaap.electionresult.service;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.entity.Party;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartyServiceTest {

    @Inject
    PartyService partyService;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        partyService = injector.getInstance(PartyService.class);
    }

    @Test
    void shouldBeAbleToCreateParty() {
        // arrange
        String partyCode = "INC";
        Party expected = new Party("INC", "Indian National Congress");

        // act
        Party actual = partyService.create(partyCode);

        // assert
        assertEquals(expected, actual);

    }


}