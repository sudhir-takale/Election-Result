package org.amaap.task;

import org.amaap.task.data.DataFileReader;
import org.amaap.task.data.exception.EmptyFilePathException;
import org.amaap.task.domain.ElectionResult;

import java.io.IOException;

public class ElectionManager {
    private DataFileReader dataFileReader;

    public ElectionManager(DataFileReader dataFileReader) {
        this.dataFileReader = dataFileReader;

    }

    public ElectionResult readDataFromFile() throws EmptyFilePathException, IOException {

        return dataFileReader.processFile("D:\\Election Result\\src\\main\\java\\org\\amaap\\task\\ElectionData.txt");

    }

    public String showWinnerOfTheElection() throws EmptyFilePathException, IOException {

        ElectionResult electionResult = readDataFromFile();
        return electionResult.getWinnerOfTheElection();
    }

    public String getFullNameOfParty() throws EmptyFilePathException, IOException {

        String winner = showWinnerOfTheElection();
        return ElectionResult.getFullNameOfParty(winner);
    }
}
