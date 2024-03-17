package org.amaap.task;

import org.amaap.task.data.DataFileReader;
import org.amaap.task.domain.ElectionResult;

public class ElectionManager {
    private DataFileReader dataFileReader;

    public ElectionManager(DataFileReader dataFileReader) {
        this.dataFileReader = dataFileReader;

    }

    public ElectionResult readDataFromFile() {

       return dataFileReader.processFile("Dummy Path");

    }


}
