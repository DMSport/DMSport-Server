package com.project.dmsport.domain.admin.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ClubBanResponse {

    private final boolean ban;

    private final LocalDate banPeriod;

}
