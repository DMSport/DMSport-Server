package com.project.dmsport.domain.notice.domain.repository;

import com.project.dmsport.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query("select n from Notice n order by n.createdDate desc")
    List<Notice> findAll();
}