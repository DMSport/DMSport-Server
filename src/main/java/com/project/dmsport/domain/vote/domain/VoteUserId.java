package com.project.dmsport.domain.vote.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class VoteUserId implements Serializable {

    private Long vote;

    private Long user;

}
