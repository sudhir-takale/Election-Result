package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.model.entity.Constituency;
import com.amaap.electionresult.repository.ConstituencyRepository;
import com.amaap.electionresult.service.exception.InvalidConstituencyFoundException;
import com.google.inject.Inject;

public class ConstituencyService {

    private final ConstituencyRepository constituencyRepository;

    @Inject
    public ConstituencyService(ConstituencyRepository constituencyRepository) {
        this.constituencyRepository = constituencyRepository;
    }


    public Constituency create(String constituencyName) throws InvalidConstituencyFoundException {
        if (constituencyName.isEmpty())
            throw new InvalidConstituencyFoundException("Invalid constituency found" + constituencyName);
        Constituency constituency = new Constituency(constituencyName);
        return constituencyRepository.save(constituency);
    }

    public boolean checkConstituency(String name) {
        return constituencyRepository.checkConstituency(name);
    }
}
