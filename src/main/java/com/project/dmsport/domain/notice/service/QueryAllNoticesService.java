package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryAllNoticesService {

    private final NoticeRepository noticeRepository;
    private final NoticeFacade noticeFacade;

    @Transactional(readOnly = true)
    public QueryAllNoticesResponse execute() {

        return new QueryAllNoticesResponse(
                noticeFacade.noticeToNoticeResponse(noticeRepository.findAllByOrderByCreatedDateDesc()));
    }
}