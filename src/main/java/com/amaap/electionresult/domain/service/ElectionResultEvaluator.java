package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.domain.service.dto.ElectionResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ElectionResultEvaluator {
    public static Optional<ElectionResultDto> getWinnerOfConstituency(List<ElectionResult> constituencies) {
        for (ElectionResult electionResult : constituencies) {
            Map<Party, Integer> partyMap = electionResult.getParty();
            Map<Party, Integer> winnerParty = getWinningParty(partyMap);
            if (!winnerParty.isEmpty()) {
                Party winningParty = winnerParty.entrySet().iterator().next().getKey();
                int winningVotes = winnerParty.entrySet().iterator().next().getValue();
                return Optional.of(new ElectionResultDto(winningParty.getPartyCode(), winningParty.getName(), winningVotes));
            }
        }
        return Optional.empty();
    }

    private static Map<Party, Integer> getWinningParty(Map<Party, Integer> partyMap) {
        Map.Entry<Party, Integer> winningEntry = partyMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow(IllegalArgumentException::new);

        Map<Party, Integer> winningPartyMap = new HashMap<>();
        winningPartyMap.put(winningEntry.getKey(), winningEntry.getValue());

        return winningPartyMap;
    }


}
