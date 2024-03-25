package org.amaap.electionresult.data;

import org.amaap.electionresult.data.exception.EmptyFilePathException;
import org.amaap.electionresult.domain.ElectionResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataFileReader {

    public ElectionResult processFile(String filePath) throws IOException, EmptyFilePathException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new EmptyFilePathException("File path is empty or null.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String location = null;
            Map<String, Integer> partyVotes = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                location = tokens[0].trim();

                for (int i = 1; i < tokens.length; i += 2) {
                    String party = tokens[i].trim();
                    int votes = Integer.parseInt(tokens[i + 1].trim());
                    partyVotes.put(party, votes);

                }
            }

            return new ElectionResult(location, partyVotes);
        }
    }
}
