package com.amaap.electionresult.domain.entity;

public class Party {
    private int id;
    private String code;
    private String name;

    public Party(String code, String name) {
        this.code = code;
        this.name = name;
    }


}
