package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllNoticesService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;
    public QueryAllNoticesResponse execute() {
        User user = userFacade.getCurrentUser();
        List<QueryAllNoticesResponse.Notice> notice = noticeRepository.findAllByOrderByCreatedDateDesc().stream()
                .map(
                        n -> QueryAllNoticesResponse.Notice.builder()
                                .id(n.getId())
                                .title(n.getTitle())
                                .contentPreview(n.getContent().substring(0,20)+"...")
                                .type(n.getNoticeType())
                                .createdAt(n.getCreatedDate())
                                .build()
                ).collect(Collectors.toList());

        return QueryAllNoticesResponse.builder()
                .notices(notice)
                .authority(user.getAuthority())
                .build();
    }
}
