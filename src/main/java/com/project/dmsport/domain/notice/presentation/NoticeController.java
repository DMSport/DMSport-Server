package com.project.dmsport.domain.notice.presentation;

import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.project.dmsport.domain.notice.service.QueryAllNoticesService;
import com.project.dmsport.domain.notice.service.QueryNoticeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final QueryAllNoticesService queryAllNoticesService;
    private final QueryNoticeDetailService queryNoticeDetailService;
    @GetMapping
    public QueryAllNoticesResponse searchAllNotices() {
        return queryAllNoticesService.execute();
    }

    @GetMapping("/{notice-id}")
    public QueryNoticeDetailResponse searchNotice(@PathVariable("notice-id") Long noticeId) {
        return queryNoticeDetailService.execute(noticeId);
    }
}
