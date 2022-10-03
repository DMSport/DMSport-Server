package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SearchNoticeResponse {
    private final String title;
    private final String content;
    private final String writer;
    private final NoticeType type;
    private final LocalDate createdAt;
}
