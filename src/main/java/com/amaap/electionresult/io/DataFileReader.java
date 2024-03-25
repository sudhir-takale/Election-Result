package com.amaap.electionresult.io;

import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.ElectionResult;
import com.amaap.electionresult.domain.model.Party;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFileReader {
    public List<ElectionResult> readResultsFromFile(String filePath) {
        List<ElectionResult> electionResults = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    continue;
                }
                String constituencyName = parts[0].trim();
                Constituency constituency = new Constituency(constituencyName);

                Map<Party, Integer> partyVotes = new HashMap<>();
                for (int i = 1; i < parts.length; i += 2) {
                    try {
                        Party party = new Party(parts[i].trim(), "");
                        int votes = Integer.parseInt(parts[i + 1].trim());
                        partyVotes.put(party, votes);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid vote count: " + parts[i + 1]);
                    }
                }

                ElectionResult electionResult = new ElectionResult(constituency, partyVotes);
                electionResults.add(electionResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return electionResults;
    }

}
