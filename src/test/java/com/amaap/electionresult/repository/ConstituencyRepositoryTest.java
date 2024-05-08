package com.amaap.electionresult.repository;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.domain.model.entity.Constituency;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstituencyRepositoryTest {

    @Inject
    ConstituencyRepository constituencyRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        constituencyRepository = injector.getInstance(ConstituencyRepository.class);
    }

    @Test
    void shouldBeAbleToSaveConstituencyToTheDatabase() {
        // arrange
        String name = "Pune";
        Constituency expected = new Constituency(name);

        // act
        Constituency actual = constituencyRepository.save(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueIfConstituencyPresent() {
        // arrange
        String name = "Pune";
        Constituency expected = new Constituency(name);
        constituencyRepository.save(expected);

        // act
        boolean actual = constituencyRepository.checkConstituency(name);

        // assert
        assertTrue(actual);
    }

}