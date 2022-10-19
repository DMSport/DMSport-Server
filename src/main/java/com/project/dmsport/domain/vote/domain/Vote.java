package com.project.dmsport.domain.vote.domain;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Vote {

    @Id
    @Column(name = "vote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private ClubType clubType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private VoteType voteType;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer count;

    @NotNull
    private LocalDate voteDate;

    @NotNull
    private boolean complete;

    @OneToMany(mappedBy = "vote")
    private List<VoteUser> voteUsers;

    @Builder
    public Vote(ClubType clubType, VoteType voteType) {
        this.clubType = clubType;
        this.voteType = voteType;
        this.count = 0;
        this.voteDate = LocalDate.now();
        this.complete = false;
    }

    public void plusCount() {
        this.count += 1;
    }

    public void minusCount() {
        this.count -= 1;
    }

    public Vote closeVote() {
        this.complete = true;
        return this;
    }

}
