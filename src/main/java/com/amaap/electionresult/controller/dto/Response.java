package com.amaap.electionresult.controller.dto;

import java.util.Objects;

public class Response {

    private final HttpStatus httpStatus;
    private final String response;

    public Response(HttpStatus httpStatus, String response) {
        this.response = response;
        this.httpStatus = httpStatus;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response1 = (Response) o;
        return httpStatus == response1.httpStatus && Objects.equals(response, response1.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus, response);
    }
}
