package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.entity.Party;
import com.amaap.electionresult.domain.valueobject.PartyName;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;

public class PartyService {

    public Party create(String partyCode) throws InvalidPartyCodeException {

        if (partyCode.isEmpty()) throw new InvalidPartyCodeException("invalid party code " + partyCode);
        String partyFullName = PartyName.getFullNameByCode(partyCode);

        return new Party(partyCode, partyFullName);
    }
}
