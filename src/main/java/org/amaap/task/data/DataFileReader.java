package org.amaap.task.data;

import org.amaap.task.data.exception.EmptyFilePathException;
import org.amaap.task.domain.ElectionResult;

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
            String location = br.readLine();
            Map<String, Integer> partyVotes = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(", ");
                for (int i = 1; i < tokens.length; i += 3) {
                    String party = tokens[i];
                    int votes = Integer.parseInt(tokens[i + 1]);
                    partyVotes.put(party, votes);
                }
            }

            return new ElectionResult(location, partyVotes);
        }
    }
}
