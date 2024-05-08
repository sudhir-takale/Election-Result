package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.repository.ElectionResultRepository;
import com.amaap.electionresult.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

public class InMemoryElectionResultRepository implements ElectionResultRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryElectionResultRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public ElectionResult save(ElectionResult electionResult) {
        return inMemoryDatabase.saveResult(electionResult);
    }
}
