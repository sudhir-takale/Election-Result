package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.ElectionResult;

import java.util.List;

public interface ElectionResultRepository {
    ElectionResult save(ElectionResult electionResult);

    List<ElectionResult> getElectionResults();
}
