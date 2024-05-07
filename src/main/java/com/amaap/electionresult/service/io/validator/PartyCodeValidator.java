package com.amaap.electionresult.service.io.validator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class PartyCodeValidator {
    private static List<String> validPartyCodes;

    public PartyCodeValidator() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("D:\\Tasks\\Election-Result\\src\\main\\java\\com\\amaap\\electionresult\\config\\PartyCode.yml");
        Map<String, List<String>> config = yaml.load(inputStream);

        validPartyCodes = config.get("party");
    }

    public  boolean isValidPartyCode(String partyCode) {
        return validPartyCodes.contains(partyCode);
    }
}
