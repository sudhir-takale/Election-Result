package org.amaap.task.data;

import org.amaap.task.data.exception.EmptyFilePathException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class DataFileReaderTest {

    @Test
    void shouldReturnFileNotFoundExceptionIfPathDoesNotExist() {

        DataFileReader dataFileReader = new DataFileReader();
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            dataFileReader.processFile("c");
        });

    }

    @Test
    void shouldThrowEmptyFilePathExceptionWhenEmptyPathIsPassed() {
        DataFileReader dataFileReader = new DataFileReader();
        Assertions.assertThrows(EmptyFilePathException.class, () -> {
            dataFileReader.processFile(" ");
        });
    }


}