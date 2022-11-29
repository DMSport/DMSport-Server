package com.project.dmsport.domain.vote.service;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.vote.domain.repository.VoteUserRepository;
import com.project.dmsport.domain.vote.presentation.dto.response.QueryTodayVoteListResponse;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import com.project.dmsport.domain.vote.presentation.dto.response.VoteResponse;
import com.project.dmsport.domain.vote.presentation.dto.response.VoteUserResponse;
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
    private final VoteRepository voteRepository;

    private final VoteUserRepository voteUserRepository;

    @Transactional(readOnly = true)
    public QueryTodayVoteListResponse execute(ClubType clubType, LocalDate date) {

        Club club = clubFacade.getClubById(clubType);

        List<VoteResponse> voteResponseList = voteRepository.findByClubTypeAndVoteDateEquals(clubType, date)
                .stream()
                .map(vote -> {
                    List<VoteUserResponse> voteUserList = voteUserRepository.findByVote(vote)
                            .stream()
                            .map(VoteUserResponse::of)
                            .collect(Collectors.toList());

                    return VoteResponse.of(vote, club, voteUserList);
                })
                .collect(Collectors.toList());

        return QueryTodayVoteListResponse.builder()
                .isBan(club.getBan())
                .banPeriod(club.getBanPeriod())
                .maxPeople(club.getMaxPeople())
                .voteList(voteResponseList)
                .build();
    }

}