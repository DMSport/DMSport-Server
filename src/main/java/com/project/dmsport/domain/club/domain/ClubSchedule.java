package com.project.dmsport.domain.club.domain;

import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.DayOfWeek;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "club_schedule_unique_constraint",
                        columnNames = {"activity_place", "day_of_week", "vote_type", "club_id"}
                )
        }
)
@DynamicInsert
@Entity
public class ClubSchedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_place", length = 10)
    private ActivityPlace activityPlace;

    @Enumerated
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, name = "vote_type")
    private VoteType voteType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @Builder
    public ClubSchedule(ActivityPlace activityPlace, DayOfWeek dayOfWeek, VoteType voteType, Club club) {
        this.activityPlace = activityPlace;
        this.dayOfWeek = dayOfWeek;
        this.voteType = voteType;
        this.club = club;
    }
}
