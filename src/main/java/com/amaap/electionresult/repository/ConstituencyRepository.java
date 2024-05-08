package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.entity.Constituency;

public interface ConstituencyRepository {
    Constituency save(Constituency constituency);
    boolean checkConstituency(String name);
}
