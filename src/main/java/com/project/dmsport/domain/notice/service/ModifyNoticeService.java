package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.request.ModifyNoticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyNoticeService {
    private final NoticeFacade noticeFacade;

    @Transactional
    public void execute(ModifyNoticeRequest request, Long noticeId) {

        String title = request.getTitle();
        String content = request.getContent();
        Notice notice = noticeFacade.findNoticeById(noticeId);
        notice.modifyNotice(title, content);
    }
}
