package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.facade.NoticeFacade;
import com.project.dmsport.domain.notice.presentation.dto.request.CreateNoticeRequest;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateClubNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateNoticeRequest request) {
        User user = userFacade.getCurrentUser();
        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .noticeType(NoticeType.getByAuthority(user.getAuthority()))
                        .user(user)
                        .build()
        );
    }
}
