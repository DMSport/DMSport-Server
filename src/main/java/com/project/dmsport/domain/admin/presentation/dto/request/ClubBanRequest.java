package com.project.dmsport.domain.admin.presentation.dto.request;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ClubBanRequest {

    @NotNull(message = "club_type은 Null일 수 없습니다.")
    private ClubType clubType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate banPeriod;

}
