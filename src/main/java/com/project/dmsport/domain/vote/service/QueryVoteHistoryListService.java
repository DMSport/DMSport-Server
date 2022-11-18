package com.project.dmsport.domain.vote.service;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.club.presentation.response.QueryVoteHistoryListResponse;
import com.project.dmsport.domain.club.presentation.response.QueryVoteHistoryListResponse.VoteResponse;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.repository.VoteRepository;
import com.project.dmsport.domain.vote.domain.repository.VoteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryVoteHistoryListService {

    private final ClubFacade clubFacade;
    private final VoteRepository voteRepository;
    private final VoteUserRepository voteUserRepository;

    @Transactional(readOnly = true)
    public QueryVoteHistoryListResponse execute(ClubType clubType) {

        Club club = clubFacade.getClubById(clubType);

        List<Vote> voteList = voteRepository.findAllByClubTypeAndCompleteTrueOrderByVoteDateDesc(clubType);

        Map<LocalDate, List<VoteResponse>> voteStore = new HashMap<>();

        for (Vote vote: voteList) {
            List<String> voteUserList = voteUserRepository.findAllByVote(vote)
                    .stream()
                    .map(voteUser -> voteUser.getUser().getName())
                    .collect(Collectors.toList());

            if(!voteStore.containsKey(vote.getVoteDate())) {
                voteStore.put(vote.getVoteDate(), new ArrayList<>(Collections.singletonList(
                        QueryVoteHistoryListResponse.of(vote, club, voteUserList))
                ));
            } else {
                voteStore.get(vote.getVoteDate())
                        .add(QueryVoteHistoryListResponse.of(vote, club, voteUserList));
            }
        }

        return new QueryVoteHistoryListResponse(voteStore);
    }

}
