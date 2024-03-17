package org.amaap.task;

import org.amaap.task.data.DataFileReader;
import org.amaap.task.data.exception.EmptyFilePathException;
import org.amaap.task.domain.ElectionResult;

import java.io.IOException;

public class ElectionManager {
    private DataFileReader dataFileReader;
    private ElectionResult electionResult;

    public ElectionManager(DataFileReader dataFileReader, ElectionResult electionResult) {
        this.dataFileReader = dataFileReader;
        this.electionResult = electionResult;

    }


    public ElectionResult readDataFromFile() throws EmptyFilePathException, IOException {

        return dataFileReader.processFile("Dummy Path");

    }


//    public String getConstituencyName() throws EmptyFilePathException, IOException {
//
//        ElectionResult electionResult = readDataFromFile();
//        return electionResult.getConstituencyName();
//    }

    public String showWinnerOfTheElection() throws EmptyFilePathException, IOException {

        ElectionResult electionResult = readDataFromFile();
        return electionResult.getWinnerOfTheElection();
    }

    public String getFullNameOfParty() throws EmptyFilePathException, IOException {

        String winner = showWinnerOfTheElection();
        return electionResult.getFullNameOfParty(winner);
    }
}
