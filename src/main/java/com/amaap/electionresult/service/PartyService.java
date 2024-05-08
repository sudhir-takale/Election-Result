package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.model.valueobject.PartyName;
import com.amaap.electionresult.repository.PartyRepository;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.google.inject.Inject;

public class PartyService {
    private final PartyRepository partyRepository;

    @Inject
    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party create(String partyCode) throws InvalidPartyCodeException {

        if (partyCode.isEmpty()) throw new InvalidPartyCodeException("invalid party code " + partyCode);
        String partyFullName = PartyName.getFullNameByCode(partyCode);

        Party party = new Party(partyCode, partyFullName);
        return partyRepository.save(party);
    }

    public Party getPartyBy(String partyCode) {
        return partyRepository.getBy(partyCode);
    }
}
