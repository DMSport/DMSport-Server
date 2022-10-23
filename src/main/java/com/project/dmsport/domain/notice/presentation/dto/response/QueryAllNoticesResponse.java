package com.project.dmsport.domain.notice.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
public class QueryAllNoticesResponse {

    private final List<NoticeResponse> notices;
    private final Authority authority;
    @Getter
    @Builder
    public static class NoticeResponse {
        private final Long id;
        private final String title;
        private final String contentPreview;
        private final NoticeType type;
        private final LocalDateTime createdAt;
    }
}
