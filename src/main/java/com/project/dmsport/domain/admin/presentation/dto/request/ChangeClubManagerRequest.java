package com.project.dmsport.domain.admin.presentation.dto.request;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ChangeClubManagerRequest {

    @NotNull(message = "club_type은 Null일 수 없습니다.")
    private ClubType clubType;

}
