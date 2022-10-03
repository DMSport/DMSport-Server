package com.project.dmsport.domain.notice.service;

import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.notice.presentation.dto.SearchAllNoticesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchAllNoticesService {
    private final NoticeRepository noticeRepository;
    public List<SearchAllNoticesResponse> execute() {
        LocalDateTime now = LocalDateTime.now();
        return noticeRepository.findAllByOrderByCreatedDateDesc().stream()
                .map(n ->
                        SearchAllNoticesResponse.builder()
                                .id(n.getId())
                                .title(n.getTitle())
                                .contentPreview(n.getContent().substring(0,20)+"...")
                                .type(n.getNoticeType())
                                .duration(Duration.between(n.getCreatedDate(), now).toDaysPart())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
