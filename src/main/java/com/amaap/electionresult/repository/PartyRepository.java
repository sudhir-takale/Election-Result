package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.Party;

public interface PartyRepository {

    Party save(Party party);

    Party getBy(String partyCode);
}
