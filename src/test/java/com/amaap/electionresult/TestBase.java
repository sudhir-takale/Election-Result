package com.amaap.electionresult;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {

        }
    });

    @BeforeEach
    public void setup() {
        injector.injectMembers(this);
    }
}