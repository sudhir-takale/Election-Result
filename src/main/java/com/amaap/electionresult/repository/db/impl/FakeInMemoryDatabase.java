package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.domain.model.entity.ElectionResult;
import com.amaap.electionresult.domain.model.entity.Party;
import com.amaap.electionresult.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {

    private List<Party> parties = new ArrayList<>();
    private List<Constituency> constituencies = new ArrayList<>();
    private List<ElectionResult> electionResults = new ArrayList<>();
    private int partyIdCounter = 0;
    private int electionIdCounter = 0;
    private int constituencyIdCounter = 0;

    @Override
    public Party save(Party party) {
        party.setId(++partyIdCounter);
        parties.add(party);
        return party;
    }

    @Override
    public Party getBy(String partyCode) {
        for (Party party : parties) {
            if (party.getPartyCode().equals(partyCode)) return party;
        }
        return null;
    }

    @Override
    public Constituency insert(Constituency constituency) {
        constituency.setId(++constituencyIdCounter);
        constituencies.add(constituency);
        return constituency;
    }

    @Override
    public boolean check(String name) {
        for (Constituency constituency : constituencies) {
            if (constituency.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    @Override
    public ElectionResult saveResult(ElectionResult electionResult) {
        String constituency = electionResult.getConstituencyName();
        for (ElectionResult election : electionResults) {
            if (election.getConstituencyName().equalsIgnoreCase(constituency)) {
                election.getParty().putAll(electionResult.getParty());
                return electionResult;
            }
        }
        electionResult.setId(++electionIdCounter);
        electionResults.add(electionResult);
        return electionResult;
    }

    @Override
    public List<ElectionResult> getElectionResults() {
        return this.electionResults;
    }
}
