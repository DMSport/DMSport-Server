package com.project.dmsport.domain.vote.domain.repository;

import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.VoteUser;
import com.project.dmsport.domain.vote.domain.VoteUserId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VoteUserRepository extends CrudRepository<VoteUser, VoteUserId> {

    Optional<VoteUser> findByVoteAndUser(Vote vote, User user);

    @EntityGraph(attributePaths = {"user"})
    List<VoteUser> findAllByVote(Vote vote);

}
