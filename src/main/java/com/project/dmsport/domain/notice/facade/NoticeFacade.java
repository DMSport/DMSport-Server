package com.project.dmsport.domain.notice.facade;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoticeFacade {
    private final NoticeRepository noticeRepository;

    public Notice findNoticeById(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }

}
