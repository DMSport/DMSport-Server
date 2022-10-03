package com.project.dmsport.domain.notice.presentation.dto.response;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class SearchAllNoticesResponse {
    private final Long id;
    private final String title;
    private final String contentPreview;
    private final NoticeType type;
    private final Long duration;
}
