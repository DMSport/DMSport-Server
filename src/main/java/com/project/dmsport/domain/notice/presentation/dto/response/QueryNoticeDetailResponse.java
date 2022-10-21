package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class QueryNoticeDetailResponse {
    private final String title;
    private final String content;
    private final String writer;
    private final NoticeType type;
    private final LocalDateTime createdAt;
}
