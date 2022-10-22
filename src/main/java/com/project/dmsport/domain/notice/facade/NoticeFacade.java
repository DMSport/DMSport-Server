package com.project.dmsport.domain.notice.facade;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.InvalidAuthorityException;
import com.project.dmsport.domain.notice.exception.NoticeNotFoundException;
import com.project.dmsport.domain.user.domain.enums.Authority;
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

    public NoticeType defineNoticeType(Authority authority) {
        switch (authority) {
            case BADMINTON_MANAGER:
                return NoticeType.BADMINTON;
            case BASKETBALL_MANAGER:
                return NoticeType.BASKETBALL;
            case SOCCER_MANAGER:
                return NoticeType.SOCCER;
            case VOLLEYBALL_MANAGER:
                return NoticeType.VOLLEYBALL;
        }
        throw InvalidAuthorityException.EXCEPTION;
    }

}
