package com.amaap.electionresult.service.io;

import com.amaap.electionresult.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.electionresult.repository.impl.InMemoryPartyRepository;
import com.amaap.electionresult.service.ConstituencyService;
import com.amaap.electionresult.service.ElectionResultService;
import com.amaap.electionresult.service.PartyService;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.amaap.electionresult.service.io.exception.EmptyFilePathException;
import com.amaap.electionresult.service.io.exception.InvalidPartyCodeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
    public boolean readFile(String filePath) throws IOException, EmptyFilePathException, InvalidPartyCodeException, InvalidConstituencyFoundException {

        if (filePath.trim().isEmpty()) throw new EmptyFilePathException("File path is empty" + filePath);

        FileParserService fileParserService =
                new FileParserService(new PartyService(new InMemoryPartyRepository(new FakeInMemoryDatabase())),
                        new ConstituencyService(), new ElectionResultService());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if (!fileParserService.parseInputLine(line)) return false;
        }
        return true;
    }
}
