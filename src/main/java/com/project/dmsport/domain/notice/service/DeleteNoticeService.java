package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.InvalidAuthorityException;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;

    @Transactional
    public void execute(Long noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findNoticeById(noticeId);
        if(!user.equals(notice.getUser()) && !user.getAuthority().equals(Authority.ADMIN)) {
            throw InvalidAuthorityException.EXCEPTION;
        }
        noticeRepository.delete(notice);
    }
}
