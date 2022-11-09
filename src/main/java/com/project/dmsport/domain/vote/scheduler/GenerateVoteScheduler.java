package com.project.dmsport.domain.vote.scheduler;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.ClubSchedule;
import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.club.domain.repository.ClubScheduleRepository;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import com.project.dmsport.global.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GenerateVoteScheduler {

    private final VoteRepository voteRepository;
    private final ClubScheduleRepository clubScheduleRepository;
    private final ClubRepository clubRepository;

    @Scheduled(cron = "0 0 8 * * MON-FRI")
    public void generateVote() {

        DayOfWeek now = LocalDateTime.now().toLocalDate().getDayOfWeek();
        List<ClubSchedule> clubScheduleList = clubScheduleRepository.findByDayOfWeek(now);

        for (ActivityPlace activityPlace : ActivityPlace.values()) {

            List<Club> activityClubList = clubRepository.findAll()
                    .stream()
                    .filter(c -> c.getPlace() == activityPlace)
                    .filter(Club::checkAndRestoreBan)
                    .collect(Collectors.toList());

            for (VoteType voteType : VoteType.values()) {

                Optional<ClubSchedule> optionalClubSchedule = clubScheduleList
                        .stream()
                        .filter(cs -> cs.getVoteType() == voteType)
                        .findFirst();

                Club club;
                if (optionalClubSchedule.isPresent()) {

                    club = optionalClubSchedule.get().getClub();
                    generateVote(club.getId(), VoteType.LUNCH);
                    generateVote(club.getId(), VoteType.DINNER);

                } else {

                    club = getRandomHopingClub(activityClubList);
                    generateVote(club.getId(), VoteType.LUNCH);

                    club = getRandomHopingClub(activityClubList);
                    generateVote(club.getId(), VoteType.DINNER);

                }
            }
        }

    }

    private Club getRandomHopingClub(List<Club> activityClubList) {
        return activityClubList
                .stream()
                .filter(Club::getHope)
                .collect(Collectors.toList())
                .get(RandomUtil.createRandomNumber(activityClubList.size()));
    }

    private void generateVote(ClubType clubType, VoteType voteType) {
        voteRepository.save(Vote.builder()
                .clubType(clubType)
                .voteType(voteType)
                .build());
    }

}