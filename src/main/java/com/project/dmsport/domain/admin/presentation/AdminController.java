package com.project.dmsport.domain.admin.presentation;

import com.project.dmsport.domain.admin.presentation.dto.request.ClubBanRequest;
import com.project.dmsport.domain.admin.presentation.dto.response.ClubBanResponse;
import com.project.dmsport.domain.admin.service.ClubBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final ClubBanService clubBanService;

    @PatchMapping("/ban")
    public ClubBanResponse clubBan(@RequestBody @Valid ClubBanRequest request) {
        return clubBanService.execute(request);
    }

}
