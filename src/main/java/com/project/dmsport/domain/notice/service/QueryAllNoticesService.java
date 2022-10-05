package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse.NoticeResponse;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllNoticesService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryAllNoticesResponse execute() {
        User user = userFacade.getCurrentUser();
        List<NoticeResponse> notice = noticeRepository.findAll()
                .stream().map(
                        n -> NoticeResponse.builder()
                                .id(n.getId())
                                .title(n.getTitle())
                                .contentPreview(n.getContent().substring(0,20)+"...")
                                .type(n.getNoticeType())
                                .createdAt(n.getCreatedDate())
                                .build()
                ).collect(Collectors.toList());

        return new QueryAllNoticesResponse(notice, user.getAuthority());
    }
}
