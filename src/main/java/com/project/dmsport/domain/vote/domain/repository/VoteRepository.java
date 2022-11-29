package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    List<Vote> findByVoteTypeAndVoteDate(VoteType voteType, LocalDate localDate);

    List<Vote> findByClubTypeAndVoteDateEquals(ClubType clubType, LocalDate date);

    List<Vote> findByClubTypeAndCompleteTrueOrderByVoteDateDesc(ClubType clubType);

}