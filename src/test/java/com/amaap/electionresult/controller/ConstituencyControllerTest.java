package com.amaap.electionresult.controller;

import com.amaap.electionresult.ElectionResultModule;
import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstituencyControllerTest {

    @Inject
    ConstituencyController constituencyController;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new ElectionResultModule());
        constituencyController = injector.getInstance(ConstituencyController.class);

    }


    @Test
    void shouldReturnOKAsResponseIfNewConstituencyCreatedSuccess() {
        // arrange
        String name = "Pune";
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = constituencyController.create(name);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldReturnBadRequestAsAResponseIfEmptyConstituencyHasPassed() {
        // arrange
        String name = "";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response actual = constituencyController.create(name);

        // assert
        assertEquals(expected, actual);
    }


}
