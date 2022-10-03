package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.response.SearchNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SearchNoticeService {
    private final NoticeFacade noticeFacade;

    public SearchNoticeResponse execute(Long noticeId) {
        Notice notice = noticeFacade.findNoticeById(noticeId);
        return SearchNoticeResponse.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .type(notice.getNoticeType())
                .writer(notice.getUser().getName())
                .createdAt(notice.getCreatedDate())
                .build();
    }
}
