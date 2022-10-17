package com.project.dmsport.domain.vote.scheduler;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class VoteScheduler {

    private final VoteRepository voteRepository;
    private final ClubRepository clubRepository;

    @Scheduled(cron = "0 0 8 * * MON-FRI")
    public void generateVote() {

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
        if(club.getBanPeriod() != null) {
            return club.getBanPeriod().isBefore(LocalDate.now());
        }
        return true;
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
