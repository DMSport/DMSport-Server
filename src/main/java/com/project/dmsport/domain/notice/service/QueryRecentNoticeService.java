package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.presentation.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryRecentNoticeService {
    private final NoticeRepository noticeRepository;

    public Map<String, List<NoticeResponse>> execute() {

        List<NoticeResponse> adminNoticeList = noticeRepository.findTop2ByNoticeTypeOrderByCreatedDateDesc(NoticeType.ALL)
                .stream()
                .map(NoticeResponse::of)
                .collect(Collectors.toList());

        List<NoticeResponse> managerNoticeList = noticeRepository.findTop2ByNoticeTypeNotOrderByCreatedDateDesc(NoticeType.ALL)
                .stream()
                .map(NoticeResponse::of)
                .collect(Collectors.toList());

        Map<String, List<NoticeResponse>> res = new HashMap<>();
        res.put("admin", adminNoticeList);
        res.put("manager", managerNoticeList);
        return res;

    }
}
