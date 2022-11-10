package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.response.NoticeResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllNoticesService {

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public QueryAllNoticesResponse execute() {
        List<NoticeResponse> notices = noticeRepository.findAllByOrderByCreatedDateDesc()
                .stream()
                .map(NoticeResponse::of)
                .collect(Collectors.toList());
        return new QueryAllNoticesResponse(notices);
    }
}