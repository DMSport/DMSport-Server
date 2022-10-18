package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findAllByCompleteFalse(Vote vote);

}
