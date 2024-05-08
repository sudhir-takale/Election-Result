package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.Constituency;

public interface ConstituencyRepository {
    Constituency save(Constituency constituency);

    boolean checkConstituency(String name);


}
