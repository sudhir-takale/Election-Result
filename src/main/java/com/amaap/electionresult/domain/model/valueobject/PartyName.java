package com.amaap.electionresult.domain.model.valueobject;

public enum PartyName {
    BJP("Bhartiya Janta Party"),
    INC("Indian National Congress"),
    BSP("Bahujan Samaj Party"),
    CPI("Communist Party of India"),
    NCP("Nationalist Congress Party"),
    IND("Independent"),
    AAP("Aam Adami Party");

    private final String fullName;

    PartyName(String fullName) {
        this.fullName = fullName;
    }

    public static String getFullNameByCode(String code) {
        for (PartyName party : values()) {
            if (party.name().equalsIgnoreCase(code)) {
                return party.getFullName();
            }
        }
        return "Invalid";
    }

    public String getFullName() {
        return fullName;
    }
}
