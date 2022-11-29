package com.project.dmsport.domain.vote.scheduler;

import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.VoteUser;
import com.project.dmsport.domain.vote.domain.enums.Team;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import com.project.dmsport.domain.vote.domain.repository.VoteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CloseVoteScheduler {

    private final VoteRepository voteRepository;
    private final VoteUserRepository voteUserRepository;

    @Scheduled(cron = "0 50 12 * * MON-FRI")
    public void closeLunchVote() {

        voteRepository.findByVoteTypeAndVoteDate(VoteType.LUNCH, LocalDate.now())
                .stream()
                .map(Vote::closeVote)
                .map(voteRepository::save)
                .forEach(vote -> {
                            List<VoteUser> voteUsers = vote.getVoteUsers();
                            teamBuilding(voteUsers);
                        }
                );
    }

    private void teamBuilding(List<VoteUser> voteUsers) {

        Collections.shuffle(voteUsers);
        int voteUsersSize = voteUsers.size();

        List<VoteUser> team1 = voteUsers.subList(0, voteUsersSize / 2);
        team1.forEach(vu -> {
            vu.setTeam(Team.TEAM1);
            voteUserRepository.save(vu);
        });

        List<VoteUser> team2 = voteUsers.subList(voteUsersSize / 2 + 1, voteUsersSize - 1);
        team2.forEach(vu -> {
            vu.setTeam(Team.TEAM2);
            voteUserRepository.save(vu);
        });
    }

    @Scheduled(cron = "0 50 17 * * MON-FRI")
    public void closeDinnerVote() {

        voteRepository.findByVoteTypeAndVoteDate(VoteType.DINNER, LocalDate.now())
                .stream()
                .map(Vote::closeVote)
                .map(voteRepository::save)
                .collect(Collectors.toList());
    }

}
