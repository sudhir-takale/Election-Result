package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.ElectionWinnerDTO;
import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.ElectionResultDTO;
import com.amaap.electionresult.domain.model.Party;

public class ElectionResultPrinter {

    public static Party getWinnerOfConstituency(ElectionResultDTO electionResultDTO, Constituency constituency) {
        ElectionWinnerDTO winnerDTO = electionResultDTO.getWinners().get(constituency);
        return winnerDTO.getWinnerParty();
    }
}

