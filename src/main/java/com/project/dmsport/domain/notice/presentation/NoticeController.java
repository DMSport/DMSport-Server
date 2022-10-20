package com.project.dmsport.domain.notice.presentation;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.project.dmsport.domain.notice.service.CreateNoticeService;
import com.project.dmsport.domain.notice.service.QueryAllNoticesService;
import com.project.dmsport.domain.notice.service.QueryNoticeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final QueryAllNoticesService queryAllNoticesService;
    private final QueryNoticeDetailService queryNoticeDetailService;
    private final CreateNoticeService createNoticeService;
    @GetMapping
    public QueryAllNoticesResponse searchAllNotices() {
        return queryAllNoticesService.execute();
    }

    @GetMapping("/{notice-id}")
    public QueryNoticeDetailResponse searchNotice(@PathVariable("notice-id") Long noticeId) {
        return queryNoticeDetailService.execute(noticeId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNotice(@RequestParam NoticeType type, @RequestBody CreateNoticeRequest request) {
        createNoticeService.execute(request, type);
    }
}
