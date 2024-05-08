package com.amaap.electionresult.repository;

import com.amaap.electionresult.domain.model.entity.ElectionResult;

public interface ElectionResultRepository {
    ElectionResult save(ElectionResult electionResult);
}
