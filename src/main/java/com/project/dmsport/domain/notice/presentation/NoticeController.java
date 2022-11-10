package com.project.dmsport.domain.notice.presentation;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.project.dmsport.domain.notice.presentation.dto.request.ModifyNoticeRequest;
import com.project.dmsport.domain.notice.presentation.dto.response.NoticeResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import com.project.dmsport.domain.notice.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final QueryAllNoticesService queryAllNoticesService;
    private final QueryNoticeDetailService queryNoticeDetailService;
    private final CreateAdminNoticeService createAdminNoticeService;
    private final CreateClubNoticeService createClubNoticeService;
    private final ModifyNoticeService modifyNoticeService;
    private final DeleteNoticeService deleteNoticeService;
    private final QueryRecentNoticeService queryRecentNoticeService;
    @GetMapping
    public QueryAllNoticesResponse searchNoticeList() {
        return queryAllNoticesService.execute();
    }

    @GetMapping("/recent")
    public Map<String, List<NoticeResponse>> searchRecentNoticeList() {
        return queryRecentNoticeService.execute();
    }

    @GetMapping("/{notice-id}")
    public QueryNoticeDetailResponse searchNoticeDetail(@PathVariable("notice-id") Long noticeId) {
        return queryNoticeDetailService.execute(noticeId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin")
    public void createAdminNotice(@Valid @RequestBody CreateNoticeRequest request, @RequestParam NoticeType type) {
        createAdminNoticeService.execute(request, type);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/club")
    public void createClubNotice(@Valid @RequestBody CreateNoticeRequest request) {
         createClubNoticeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{notice-id}")
    public void modifyNotice(@PathVariable("notice-id") Long noticeId, @Valid @RequestBody ModifyNoticeRequest request) {
        modifyNoticeService.execute(request, noticeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}")
    public void deleteNotice(@PathVariable("notice-id") Long noticeId) {
        deleteNoticeService.execute(noticeId);
    }

}
