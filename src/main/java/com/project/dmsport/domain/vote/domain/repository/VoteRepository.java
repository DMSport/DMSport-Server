package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findAllByVoteTypeAndCompleteFalse(VoteType voteType);

    List<Vote> findAllByClubTypeAndVoteDateEquals(ClubType clubType, LocalDate date);

}
