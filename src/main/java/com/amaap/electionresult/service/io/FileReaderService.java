package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.io.exception.EmptyFilePathException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
    public boolean readFile(String filePath) throws IOException, IOException, EmptyFilePathException {

        if (filePath.trim().isEmpty()) throw new EmptyFilePathException("File path is empty" + filePath);

        FileParserService fileParserService = new FileParserService();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if (!fileParserService.parseInputLine(line)) return false;
        }
        return true;
    }
}
