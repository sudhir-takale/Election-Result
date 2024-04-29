package com.amaap.electionresult.service.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
    public static boolean readFile(String filePath) throws IOException, IOException {

        FileParserService fileParserService = new FileParserService();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if (!fileParserService.parseInputLine(line)) return false;
        }
        return true;
    }
}
