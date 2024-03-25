package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class PartyTest {

    @Test
    public void shouldReturnPartyCode() {
        // Arrange
        String code = "BJP";
        String name = "Bhartiya Janta Party";
        Party party = new Party(code, name);
        // Act
        String actualCode = party.getCode();
        // Assert
        assertEquals(code, actualCode);
    }

    @Test
    public void shouldBeAbleToReturnPartyName() {
        // Arrange
        String code = "BJP";
        String name = "Bhartiya Janta Party";
        Party party = new Party(code, name);
        // Act
        String actualName = party.getName();
        // Assert
        assertEquals(name, actualName);
    }

    @Test
    public void shouldBeAbleToSetPartyCode() {
        // Arrange
        String code = "BJP";
        String name = "Bhartiya Janta Party";
        Party party = new Party("", name);
        // Act
        party.setCode(code);
        // Assert
        assertEquals(code, party.getCode());
    }


}
