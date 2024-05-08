package com.amaap.electionresult;

import com.amaap.electionresult.repository.ConstituencyRepository;
import com.amaap.electionresult.repository.ElectionResultRepository;
import com.amaap.electionresult.repository.PartyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryConstituencyRepository;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.repository.impl.InMemoryPartyRepository;
import com.google.inject.AbstractModule;

public class ElectionResultModule extends AbstractModule {

    @Override
    public void configure() {
        bind(PartyRepository.class).to(InMemoryPartyRepository.class);
        bind(ConstituencyRepository.class).to(InMemoryConstituencyRepository.class);
        bind(ElectionResultRepository.class).to(InMemoryElectionResultRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
    }
}
