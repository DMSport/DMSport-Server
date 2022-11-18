package com.project.dmsport.domain.vote.scheduler;

import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CloseVoteScheduler {

    private final VoteRepository voteRepository;

    @Scheduled(cron = "0 50 12 * * MON-FRI")
    public void closeLunchVote() {

        voteRepository.findByVoteTypeAndCompleteFalse(VoteType.LUNCH)
                .stream()
                .map(Vote::closeVote)
                .map(voteRepository::save)
                .collect(Collectors.toList());
    }

    @Scheduled(cron = "0 50 17 * * MON-FRI")
    public void closeDinnerVote() {

        voteRepository.findByVoteTypeAndCompleteFalse(VoteType.DINNER)
                .stream()
                .map(Vote::closeVote)
                .map(voteRepository::save)
                .collect(Collectors.toList());
    }

}
