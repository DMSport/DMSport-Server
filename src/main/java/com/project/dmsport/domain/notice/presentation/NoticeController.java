package com.project.dmsport.domain.notice.presentation;

import com.project.dmsport.domain.notice.presentation.dto.response.SearchAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.SearchNoticeResponse;
import com.project.dmsport.domain.notice.service.SearchAllNoticesService;
import com.project.dmsport.domain.notice.service.SearchNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final SearchAllNoticesService searchAllNoticesService;
    private final SearchNoticeService searchNoticeService;
    @GetMapping("/")
    public List<SearchAllNoticesResponse> searchAllNotices() {
        return searchAllNoticesService.execute();
    }

    @GetMapping("/{notice-id}")
    public SearchNoticeResponse searchNotice(@PathVariable("notice-id") Long noticeId) {
        return searchNoticeService.execute(noticeId);
    }
}
