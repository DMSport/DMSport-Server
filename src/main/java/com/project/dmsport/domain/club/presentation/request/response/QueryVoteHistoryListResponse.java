package com.project.dmsport.domain.club.presentation.request.response;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class QueryVoteHistoryListResponse {

        private final Map<LocalDate, List<VoteResponse>> list;

        @Getter
        @Builder
        public static class VoteResponse {
                private final Long voteId;
                private final VoteType time;
                private final Integer voteCount;
                private final Integer maxPeople;
        }

        public static VoteResponse of(Vote vote, Club club) {
                return VoteResponse.builder()
                        .voteId(vote.getId())
                        .time(vote.getVoteType())
                        .voteCount(vote.getCount())
                        .maxPeople(club.getMaxPeople())
                        .build();
        }

}
