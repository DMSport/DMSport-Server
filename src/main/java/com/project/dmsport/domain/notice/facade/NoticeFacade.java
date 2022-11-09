package com.project.dmsport.domain.notice.facade;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.InvalidAuthorityException;
import com.project.dmsport.domain.notice.exception.NoticeNotFoundException;
import com.project.dmsport.domain.notice.presentation.dto.response.NoticeResponse;
import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class NoticeFacade {
    private final NoticeRepository noticeRepository;

    public Notice findNoticeById(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }

    public List<NoticeResponse> noticeToNoticeResponse(List<Notice> notices) {
        return notices.stream()
                .map(
                        n -> NoticeResponse.builder()
                                .id(n.getId())
                                .title(n.getTitle())
                                .contentPreview(generateContent(n))
                                .type(n.getNoticeType())
                                .createdAt(n.getCreatedDate())
                                .build()
                ).collect(Collectors.toList());
    }

    private String generateContent(Notice notice) {
        String content = notice.getContent();
        return content.length() > 20 ? content.substring(0, 20) : content;
    }
}
