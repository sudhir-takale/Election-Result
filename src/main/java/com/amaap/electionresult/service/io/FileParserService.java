package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.ElectionResultService;
import com.amaap.electionresult.service.PartyService;
import com.google.inject.Inject;

public class FileParserService {
    private final PartyService partyService;
    private final ConstituencyService constituencyService;
    private final ElectionResultService electionResultService;

    @Inject
    public FileParserService(PartyService partyService, ConstituencyService constituencyService, ElectionResultService electionResultService) {
        this.partyService = partyService;
        this.constituencyService = constituencyService;
        this.electionResultService = electionResultService;
    }

    public boolean parseInputLine(String line) {


        String[] parts = line.split(",");
        String constituencyName = parts[0];
        for (int i = 1; i < parts.length - 1; i++) {

            String partyCode = parts[i];
            int voteCount = Integer.parseInt(parts[i + 1]);
            partyService.create(partyCode);
            electionResultService.create(constituencyName, partyCode, voteCount);
        }

        constituencyService.create(constituencyName);

        return true;
    }
}
