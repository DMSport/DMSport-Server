package com.project.dmsport.domain.notice.domain.repository;

import com.project.dmsport.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
    List<Notice> findAllByOrderByCreatedDateDesc();
}