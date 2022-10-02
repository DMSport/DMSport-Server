package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.vote.domain.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
