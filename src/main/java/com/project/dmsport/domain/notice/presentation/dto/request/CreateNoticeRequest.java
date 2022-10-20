package com.project.dmsport.domain.notice.presentation.dto.request;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateNoticeRequest {
    private String title;
    private String content;
}
