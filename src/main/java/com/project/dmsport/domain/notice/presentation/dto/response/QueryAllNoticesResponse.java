package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
public class QueryAllNoticesResponse {

    private final List<Notice> notices;
    private final Authority authority;
    @Getter
    @Builder
    public static class Notice {
        private final Long id;
        private final String title;
        private final String contentPreview;
        private final NoticeType type;
        private final LocalDateTime createdAt;
    }
}
