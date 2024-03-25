package com.amaap.electionresult;

import com.amaap.electionresult.domain.model.Constituency;
import com.amaap.electionresult.domain.model.ElectionResult;
import com.amaap.electionresult.domain.model.ElectionResultDTO;
import com.amaap.electionresult.domain.model.Party;
import com.amaap.electionresult.domain.service.ElectionResultPrinter;
import com.amaap.electionresult.domain.service.ElectionResultProcessor;
import com.amaap.electionresult.io.DataFileReader;

import java.io.IOException;
import java.util.List;

public class ElectionManager {

    private final DataFileReader dataFileReader;
    private final ElectionResultProcessor electionResultProcessor;

    public ElectionManager(DataFileReader dataFileReader, ElectionResultProcessor electionResultProcessor) {
        this.dataFileReader = dataFileReader;
        this.electionResultProcessor = electionResultProcessor;
    }

    public ElectionResultDTO processElectionResultsFromFile(String filePath) throws IOException {
        List<ElectionResult> electionResults = dataFileReader.readResultsFromFile("D:\\Tasks\\Election-Result\\src\\main\\java\\org\\amaap\\electionresult\\ElectionData.txt");
        return electionResultProcessor.processElectionResults(electionResults);
    }

    public Party getWinnerOfConstituency(ElectionResultDTO electionResultDTO, Constituency constituency) {
        return ElectionResultPrinter.getWinnerOfConstituency(electionResultDTO, constituency);
    }

}
