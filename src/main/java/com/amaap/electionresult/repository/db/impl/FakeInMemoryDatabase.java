package com.amaap.electionresult.repository.db.impl;

import com.amaap.electionresult.domain.entity.Constituency;
import com.amaap.electionresult.domain.entity.Party;
import com.amaap.electionresult.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {

    private List<Party> parties = new ArrayList<>();
    private List<Constituency> constituencies = new ArrayList<>();
    private int partyIdCounter = 0;
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
}
