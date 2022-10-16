package com.project.dmsport.domain.vote.scheduler;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class VoteScheduler {

    private final VoteRepository voteRepository;
    private final ClubRepository clubRepository;

    @Scheduled(fixedDelay = 10 * 1000)
    public void schedule() {
        log.info("씨발");
        List<Club> clubList = clubRepository.findAll()
                .stream()
                .filter(this::checkClubActivity)
                .map(Club::restoreBan)
                .map(clubRepository::save)
                .collect(Collectors.toList());

        for(Club club : clubList) {
            generateLunchVote(club.getClubType());
            generateDinnerVote(club.getClubType());
        }
    }

    private boolean checkClubActivity(Club club) {
        return club.getBanPeriod().isBefore(LocalDate.now());
    }

    private void generateLunchVote(ClubType clubType) {
        generateVote(clubType, VoteType.LUNCH);
    }

    private void generateDinnerVote(ClubType clubType) {
        generateVote(clubType, VoteType.DINNER);
    }

    private void generateVote(ClubType clubType, VoteType voteType) {
        voteRepository.save(Vote.builder()
                .clubType(clubType)
                .voteType(voteType)
                .build());
    }

}
