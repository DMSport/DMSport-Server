package com.project.dmsport.domain.vote.domain;

import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(VoteUserId.class)
@Entity
public class VoteUser extends BaseTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id", nullable = false)
    private Vote vote;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public VoteUser(Vote vote, User user) {
        this.vote = vote;
        this.user = user;
    }

}
