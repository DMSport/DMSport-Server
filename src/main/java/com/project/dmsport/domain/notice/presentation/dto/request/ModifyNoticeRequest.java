package com.project.dmsport.domain.notice.presentation.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyNoticeRequest {
    private String title;
    private String content;
}
