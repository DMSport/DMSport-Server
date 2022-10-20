package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("select v from Vote v where v.voteType = 'LUNCH' and v.complete = false")
    List<Vote> findAllByVoteTypeLunchAndCompleteFalse();

    @Query("select v from Vote v where v.voteType = 'DINNER' and v.complete = false")
    List<Vote> findAllByVoteTypeDinnerAndCompleteFalse();


}
