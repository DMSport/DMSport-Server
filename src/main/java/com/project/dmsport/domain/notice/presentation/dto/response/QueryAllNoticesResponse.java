package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
public class QueryAllNoticesResponse {

    private final List<NoticeResponse> notices;
}