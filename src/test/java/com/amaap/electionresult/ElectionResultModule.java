package com.amaap.electionresult;

import com.amaap.electionresult.repository.PartyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryPartyRepository;
import com.google.inject.AbstractModule;

public class ElectionResultModule extends AbstractModule {

    @Override
    public void configure() {
        bind(PartyRepository.class).to(InMemoryPartyRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class);
    }
}
