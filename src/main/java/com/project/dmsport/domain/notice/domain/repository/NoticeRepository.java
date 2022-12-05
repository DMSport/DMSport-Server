package com.project.dmsport.domain.notice.domain.repository;

import com.project.dmsport.domain.notice.domain.Notice;
import com.project.dmsport.domain.notice.domain.enums.NoticeType;
import com.project.dmsport.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.OrderBy;
import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
    List<Notice> findAllByOrderByCreatedDateDesc();

    List<Notice> findTop2ByNoticeTypeOrderByCreatedDateDesc(NoticeType noticeType);

    List<Notice> findTop2ByNoticeTypeNotOrderByCreatedDateDesc(NoticeType noticeType);

    void deleteByUser(User user);

}