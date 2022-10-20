package com.project.dmsport.domain.admin.presentation.dto.request;

import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;

@Getter
@NoArgsConstructor
public class AssignClubDayRequest {

    @NotNull(message = "club_type은 Null일 수 없습니다.")
    private ClubType clubType;

    @NotNull(message = "activity_place는 Null일 수 없습니다.")
    private ActivityPlace activityPlace;

    @NotNull(message = "day_of_week는 Null일 수 없습니다.")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "vote_type는 Null일 수 없습니다.")
    private VoteType voteType;

}
