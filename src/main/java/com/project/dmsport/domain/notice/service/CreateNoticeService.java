package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.exception.NoAuthorityException;
import com.project.dmsport.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;
    public void execute(CreateNoticeRequest request, NoticeType type) {
        if(userFacade.getCurrentUser().getAuthority().equals(Authority.USER)) {
            throw NoAuthorityException.EXCEPTION;
        }
        String title = request.getTitle();
        String content = request.getContent();

        noticeRepository.save(
                Notice.builder()
                        .title(title)
                        .content(content)
                        .noticeType(type)
                        .build()
        );
    }
}
