package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse;
import com.project.dmsport.domain.notice.presentation.dto.response.QueryAllNoticesResponse.NoticeResponse;
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
                .map(
                        n -> NoticeResponse.builder()
                                .id(n.getId())
                                .title(n.getTitle())
                                .contentPreview(generateContent(n))
                                .type(n.getNoticeType())
                                .createdAt(n.getCreatedDate())
                                .build()
                ).collect(Collectors.toList());

        return new QueryAllNoticesResponse(notices);
    }

    private String generateContent(Notice notice) {
        String content = notice.getContent();
        return content.length() > 20 ? content.substring(0, 20) : content;
    }
}