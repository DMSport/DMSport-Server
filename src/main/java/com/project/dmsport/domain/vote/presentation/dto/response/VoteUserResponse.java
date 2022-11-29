package com.project.dmsport.domain.vote.presentation.dto.response;

import com.project.dmsport.domain.vote.domain.VoteUser;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoteUserResponse {

    private final String name;
    private final Integer team;

    public static VoteUserResponse of(VoteUser voteUser) {
        return VoteUserResponse
                .builder()
                .name(voteUser.getUser().getName())
                .team(voteUser.getTeam().ordinal())
                .build();
    }
}
