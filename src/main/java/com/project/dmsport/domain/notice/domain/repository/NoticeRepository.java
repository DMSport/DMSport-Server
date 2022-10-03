package com.project.dmsport.domain.notice.domain.repository;

import com.project.dmsport.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
