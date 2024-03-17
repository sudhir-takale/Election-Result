package org.amaap.task.data;

import org.amaap.task.data.exception.EmptyFilePathException;
import org.amaap.task.domain.ElectionResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class DataFileReaderTest {

    private DataFileReader dataFileReader;

    @BeforeEach
    void setUp() {
        dataFileReader = new DataFileReader();

    }

    @Test
    void shouldReturnFileNotFoundExceptionIfPathDoesNotExist() {

        Assertions.assertThrows(FileNotFoundException.class, () -> {
            dataFileReader.processFile("c");
        });

    }

    @Test
    void shouldThrowEmptyFilePathExceptionWhenEmptyPathIsPassed() {
        Assertions.assertThrows(EmptyFilePathException.class, () -> {
            dataFileReader.processFile(" ");
        });
    }


    @Test
    void shouldBeAbleToReadDataFromFile() throws EmptyFilePathException, IOException {

        ElectionResult data = dataFileReader.processFile("D:\\Election Result\\src\\main\\java\\org\\amaap\\task\\ElectionData.txt");
        System.out.println(data);
        Assertions.assertNotNull(data);


    }


}