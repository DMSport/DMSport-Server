package com.project.dmsport.domain.vote.presentation.dto.response;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.vote.domain.Vote;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import com.project.dmsport.domain.vote.presentation.dto.response.VoteUserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class QueryVoteHistoryListResponse {

        private final Map<LocalDate, List<VoteResponse>> voteList;

}
