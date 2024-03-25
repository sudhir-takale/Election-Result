package com.amaap.electionresult.io.exceptions;

public class InvalidFilePathException extends Throwable {
    public InvalidFilePathException(String invalidFilePath) {
        super(invalidFilePath);
    }
}
