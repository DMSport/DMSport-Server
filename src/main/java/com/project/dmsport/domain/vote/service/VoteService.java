package com.project.dmsport.domain.vote.service;

import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.VoteUser;
import com.project.dmsport.domain.vote.domain.VoteUserId;
import com.project.dmsport.domain.vote.domain.repository.VoteUserRepository;
import com.project.dmsport.domain.vote.exception.VoteNotFound;
import com.project.dmsport.domain.vote.facade.VoteFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VoteService {

    private final VoteUserRepository voteUserRepository;
    private final UserFacade userFacade;
    private final VoteFacade voteFacade;

    @Transactional
    public void execute(Long voteId) {

        User user = userFacade.getCurrentUser();
        Vote vote = voteFacade.getVoteById(voteId);

        if(vote.isComplete()) {
            throw VoteNotFound.EXCEPTION;
        }

        if (voteUserRepository.findByVoteAndUser(vote, user).isPresent()) {
            cancelVote(vote, user);
        } else {
            doVote(vote, user);
        }
    }

    private void doVote(Vote vote, User user) {

        vote.plusCount();
        voteUserRepository.save(VoteUser.builder()
                .vote(vote)
                .user(user)
                .build());
    }

    private void cancelVote(Vote vote, User user) {

        vote.minusCount();
        voteUserRepository.deleteById(VoteUserId.builder()
                .vote(vote.getId())
                .user(user.getId())
                .build());
    }

}