package com.amaap.electionresult.domain.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartyNameValidator {
    private static final Set<String> constituency = new HashSet<>(Arrays.asList("Bangalore", "Pune", "Mumbai", "Hyderabad"));
    private static final Set<String> parties = new HashSet<>(Arrays.asList("BJP", "INC", "BSP", "CPI", "NCP", "IND"));

    public static boolean isValidConstituency(String name) {
        return constituency.contains(name);
    }

    public static boolean isValidParty(String name) {
        return parties.contains(name);
    }
}
