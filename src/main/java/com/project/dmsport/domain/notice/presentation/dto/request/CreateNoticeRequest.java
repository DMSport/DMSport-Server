package com.project.dmsport.domain.notice.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateNoticeRequest {
    @NotEmpty(message = "title은 공백이 혀용되지 않습니다.")
    @Size(max = 20, message = "title은 20자를 넘겨선 안됩니다.")
    private String title;

    @NotEmpty(message = "content는 공백이 허용되지 않습니다.")
    private String content;
}
