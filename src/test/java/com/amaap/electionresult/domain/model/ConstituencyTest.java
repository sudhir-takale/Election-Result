package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstituencyTest {

    @Test
    void shouldReturnNameOfConstituency() {
//        Arrange & Act
        Constituency constituency = new Constituency("Pune");
//        Assert
        Assertions.assertEquals("Pune", constituency.getName());

    }


}
