package com.project.dmsport.domain.notice.facade;

import com.project.dmsport.domain.club.domain.repository.ClubManagerRepository;
import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.NoticeNotFoundException;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.global.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoticeFacade {
    private final NoticeRepository noticeRepository;
    private final ClubManagerRepository clubManagerRepository;
    public Notice findNoticeById(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }

    public void validateUser(User user, NoticeType type) {
        if(user.getAuthority().equals(Authority.ADMIN)){
            return;
        }
    }
}
