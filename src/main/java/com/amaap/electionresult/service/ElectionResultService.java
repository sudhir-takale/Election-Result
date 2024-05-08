package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.repository.ElectionResultRepository;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class ElectionResultService {

    private final ElectionResultRepository electionResultRepository;
    private final PartyService partyService;

    @Inject
    public ElectionResultService(ElectionResultRepository electionResultRepository, PartyService partyService) {
        this.electionResultRepository = electionResultRepository;
        this.partyService = partyService;
    }

    public ElectionResult create(String constituencyName, String partyCode, int voteCount) throws IllegalAccessException {

        Party party = partyService.getPartyBy(partyCode);
        if (party == null) throw new IllegalAccessException("party not found with code" + partyCode);
        Map<Party, Integer> partyMap = new HashMap<>();
        partyMap.put(party, voteCount);

        ElectionResult electionResult = new ElectionResult(constituencyName, partyMap);
        return electionResultRepository.save(electionResult);
    }
}

