package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.entity.Party;
import com.amaap.electionresult.repository.PartyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

public class InMemoryPartyRepository implements PartyRepository {

    private final InMemoryDatabase inMemoryDatabase;
    @Inject
    public InMemoryPartyRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Party save(Party party) {
        return inMemoryDatabase.save(party);
    }

    @Override
    public Party getBy(String partyCode) {
        return inMemoryDatabase.getBy(partyCode);
    }
}
