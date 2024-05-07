package com.amaap.electionresult.repository.db;

import com.amaap.electionresult.domain.entity.Party;

public interface InMemoryDatabase {
    Party save(Party party);

    Party getBy(String partyCode);
}
