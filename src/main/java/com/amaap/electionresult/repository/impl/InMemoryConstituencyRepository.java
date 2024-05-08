package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.domain.entity.Constituency;
import com.amaap.electionresult.repository.ConstituencyRepository;

public class InMemoryConstituencyRepository implements ConstituencyRepository {
    @Override
    public Constituency save(Constituency constituency) {
        return null;
    }

    @Override
    public boolean checkConstituency(String name) {
        return false;
    }
}
