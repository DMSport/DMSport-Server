package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryNoticeDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class QueryNoticeDetailService {
    private final NoticeFacade noticeFacade;

    public QueryNoticeDetailResponse execute(Long noticeId) {
        Notice notice = noticeFacade.findNoticeById(noticeId);
        return QueryNoticeDetailResponse.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .type(notice.getNoticeType())
                .writer(notice.getUser().getName())
                .createdAt(notice.getCreatedDate().toLocalDate())
                .build();
    }
}
