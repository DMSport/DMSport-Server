package com.project.dmsport.domain.club.service;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.club.presentation.request.response.QueryTodayVoteListResponse;
import com.project.dmsport.domain.club.presentation.request.response.QueryTodayVoteListResponse.VoteResponse;
import com.project.dmsport.domain.vote.facade.VoteFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryTodayVoteListService {

    private final ClubFacade clubFacade;
    private final VoteFacade voteFacade;

    @Transactional(readOnly = true)
    public QueryTodayVoteListResponse execute(ClubType clubType, LocalDate date) {

        Club club = clubFacade.getClubById(clubType);

        List<VoteResponse> voteResponseList = voteFacade.getVoteListByClubTypeAndDate(clubType, date)
                .stream()
                .map(vote -> VoteResponse.builder()
                        .voteId(vote.getId())
                        .time(vote.getVoteType())
                        .voteCount(vote.getCount())
                        .build())
                .collect(Collectors.toList());

        return QueryTodayVoteListResponse.builder()
                .isBan(club.isBan())
                .banPeriod(club.getBanPeriod())
                .maxPeople(club.getMaxPeople())
                .vote(voteResponseList)
                .build();
    }

}
