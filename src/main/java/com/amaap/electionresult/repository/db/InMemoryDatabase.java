package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.Party;

public interface InMemoryDatabase {
    Party save(Party party);

    Party getBy(String partyCode);

    Constituency insert(Constituency constituency);

    boolean check(String name);
}
