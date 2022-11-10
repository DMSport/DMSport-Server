package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class NoticeResponse {
    private final Long id;
    private final String title;
    private final String contentPreview;
    private final NoticeType type;
    private final LocalDateTime createdAt;

    public static NoticeResponse of(Notice notice) {
        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .contentPreview(notice.generateContent())
                .type(notice.getNoticeType())
                .createdAt(notice.getCreatedDate())
                .build();
    }
}
