package com.amaap.electionresult.service;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PartyServiceTest {

    @Inject
    PartyService partyService;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        partyService = injector.getInstance(PartyService.class);
    }

    @Test
    void shouldBeAbleToCreateParty() throws InvalidPartyCodeException {
        // arrange
        String partyCode = "INC";
        Party expected = new Party("INC", "Indian National Congress");

        // act
        Party actual = partyService.create(partyCode);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldThrowExceptionIfPartyCodeIsEmpty() {
        // arrange
        String partyCode = "";

        // assert
        assertThrows(InvalidPartyCodeException.class, () -> partyService.create(partyCode));

    }

    @Test
    void shouldBeAbleToSavePartyIntoRepository() throws InvalidPartyCodeException {
        // arrange
        String partyCode = "INC";
        Party expected = new Party("INC", "Indian National Congress");

        // act
        Party actual = partyService.create(partyCode);

        // assert
        assertEquals(expected, actual);

    }
    @Test
    void shouldBeAbleToGetPartyByCode() throws InvalidPartyCodeException {
        // arrange
        String partyCode = "INC";
        partyService.create(partyCode);

        // act
        Party actual = partyService.getPartyBy("INC");

        // assert
        assertEquals("INC", actual.getPartyCode());
    }



}