package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.ElectionResultService;
import com.amaap.electionresult.service.PartyService;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.amaap.electionresult.service.io.exception.InvalidInputLineException;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;
import com.amaap.electionresult.service.io.validator.PartyCodeValidator;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

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

    public boolean parseInputLine(String line) throws FileNotFoundException, InvalidPartyCodeException, InvalidConstituencyFoundException, IllegalAccessException, InvalidInputLineException {

        PartyCodeValidator partyCodeValidator = new PartyCodeValidator();
        line = line.trim();
        System.out.println(line);

        if (!Pattern.matches("([A-Z]+,([A-Za-z]+,\\d{3,}))", line)) {
            throw new InvalidInputLineException("Invalid input line " + line);
        }

        String[] parts = line.split(",");
        for(String part : parts ) System.out.println(part);
        String constituencyName = parts[0];
        for (int i = 1; i < parts.length - 1; i += 2) {

            String partyCode = parts[i];
            int voteCount = Integer.parseInt(parts[i + 1]);

            if (partyCodeValidator.isValidPartyCode(partyCode)) {
                partyService.create(partyCode);
                electionResultService.create(constituencyName, partyCode, voteCount);
            } else throw new InvalidPartyCodeException("Invalid party code " + partyCode);
        }

        constituencyService.create(constituencyName);

        return true;
    }
}
