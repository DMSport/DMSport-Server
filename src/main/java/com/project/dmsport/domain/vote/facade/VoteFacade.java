package com.project.dmsport.domain.vote.facade;

import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import com.project.dmsport.domain.vote.exception.VoteNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VoteFacade {

    private final VoteRepository voteRepository;

    public Vote getVoteById(Long voteId) {
        return voteRepository.findById(voteId)
                .orElseThrow(() -> VoteNotFound.EXCEPTION);
    }

    public void checkComplete(Vote vote) {
        if(vote.isComplete()) {
            throw VoteNotFound.EXCEPTION;
        }
    }

}