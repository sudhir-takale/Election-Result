package com.amaap.electionresult.domain.entity;

import java.util.Objects;

public class Constituency {
    private int id;
    private final String name;

    public Constituency(String name) {

        this.name = name;

    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constituency that = (Constituency) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
