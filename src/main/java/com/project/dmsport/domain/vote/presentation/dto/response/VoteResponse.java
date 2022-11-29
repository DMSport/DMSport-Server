package com.project.dmsport.domain.vote.presentation.dto.response;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class VoteResponse {
    private final Long voteId;
    private final VoteType time;
    private final Integer voteCount;
    private final Integer maxPeople;
    private final Boolean isComplete;
    private final List<VoteUserResponse> voteUser;

    public static VoteResponse of(Vote vote, Club club, List<VoteUserResponse> voteUserList) {
        return VoteResponse.builder()
                .voteId(vote.getId())
                .time(vote.getVoteType())
                .voteCount(vote.getCount())
                .isComplete(vote.getComplete())
                .maxPeople(club.getMaxPeople())
                .voteUser(voteUserList)
                .build();
    }
}