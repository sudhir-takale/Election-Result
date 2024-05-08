package com.amaap.electionresult.service;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.entity.Constituency;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ConstituencyServiceTest {

    @Inject
    ConstituencyService constituencyService;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        constituencyService = injector.getInstance(ConstituencyService.class);
    }

    @Test
    void shouldBeAbleToCrateANewConstituency() throws InvalidConstituencyFoundException {
        // arrange
        String name = "Pune";
        Constituency expected = new Constituency(name);

        // act
        Constituency actual = constituencyService.create(name);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToCheckWhetherThePassedConstituencyIsValidOrNot() {
        // arrange
        String name = "Pune";
        new Constituency(name);

        // act
        boolean actual = constituencyService.checkConstituency("Hyderabad");

        // assert
        assertFalse(actual);
    }
}