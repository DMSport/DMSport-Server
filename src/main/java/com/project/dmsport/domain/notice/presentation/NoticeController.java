package com.project.dmsport.domain.notice.presentation;

import com.project.dmsport.domain.notice.presentation.dto.SearchAllNoticesResponse;
import com.project.dmsport.domain.notice.service.SearchAllNoticesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final SearchAllNoticesService searchAllNoticesService;

    @GetMapping("/")
    public List<SearchAllNoticesResponse> searchAllNotices() {
        searchAllNoticesService.execute();
    }
}
