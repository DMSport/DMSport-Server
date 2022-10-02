package com.project.dmsport.domain.vote.domain;

import com.project.dmsport.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(VoteUserId.class)
@Entity
public class VoteUser {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id", nullable = false)
    private Vote vote;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private LocalDateTime voteTime;

    @Builder
    public VoteUser(Vote vote, User user) {
        this.vote = vote;
        this.user = user;
        this.voteTime = LocalDateTime.now();
    }

}
