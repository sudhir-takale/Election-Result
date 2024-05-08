package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.entity.Constituency;
import com.amaap.electionresult.repository.ConstituencyRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

public class InMemoryConstituencyRepository implements ConstituencyRepository {

    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryConstituencyRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Constituency save(Constituency constituency) {
        return inMemoryDatabase.insert(constituency);
    }

    @Override
    public boolean checkConstituency(String name) {
        return inMemoryDatabase.check(name);
    }
}
