package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.exception.NoAuthorityException;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.request.ModifyNoticeRequest;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyNoticeService {
    private final NoticeFacade noticeFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(ModifyNoticeRequest request, Long noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findNoticeById(noticeId);
        if(!user.getEmail().equals(notice.getUser().getEmail())) {
            throw NoAuthorityException.EXCEPTION;
        }
        String title = request.getTitle();
        String content = request.getContent();
        notice.modifyNotice(title, content);
    }
}
