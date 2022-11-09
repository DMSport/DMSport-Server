package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QueryRecentNoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeFacade noticeFacade;

    public Map<String, List<NoticeResponse>> execute() {

        List<NoticeResponse> admin = noticeFacade.noticeToNoticeResponse(
                noticeRepository.findTop2ByNoticeTypeOrderByCreatedDateDesc(NoticeType.ALL));
        List<NoticeResponse> manager = noticeFacade.noticeToNoticeResponse(
                noticeRepository.findTop2ByNoticeTypeNotOrderByCreatedDateDesc(NoticeType.ALL));

        Map<String, List<NoticeResponse>> res = new HashMap<>();
        res.put("admin", admin);
        res.put("manager", manager);
        return res;

    }
}
