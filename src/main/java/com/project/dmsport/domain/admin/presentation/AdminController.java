package com.project.dmsport.domain.admin.presentation;

import com.project.dmsport.domain.admin.presentation.dto.request.AssignClubDayRequest;
import com.project.dmsport.domain.admin.presentation.dto.request.ChangeClubManagerRequest;
import com.project.dmsport.domain.admin.presentation.dto.request.ClubBanRequest;
import com.project.dmsport.domain.admin.presentation.dto.response.ClubBanResponse;
import com.project.dmsport.domain.admin.presentation.dto.response.UserListResponse;
import com.project.dmsport.domain.admin.service.AssignClubDayService;
import com.project.dmsport.domain.admin.service.ChangeClubManagerService;
import com.project.dmsport.domain.admin.service.ClubBanService;
import com.project.dmsport.domain.admin.service.QueryUserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final AssignClubDayService assignClubDayService;
    private final ClubBanService clubBanService;
    private final ChangeClubManagerService changeClubManagerService;
    private final QueryUserListService queryUserListService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/club")
    public void assignClubDay(@RequestBody @Valid AssignClubDayRequest request) {
        assignClubDayService.execute(request);
    }

    @PatchMapping("/ban")
    public ClubBanResponse clubBan(@RequestBody @Valid ClubBanRequest request) {
        return clubBanService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/users/manager/{user-id}")
    public void changeClubManager(@PathVariable(name = "user-id") Long userId,
                                  @RequestBody @Valid ChangeClubManagerRequest request) {
        changeClubManagerService.execute(request, userId);
    }

    @GetMapping("/users")
    public List<UserListResponse> searchAllUsers() {
        return queryUserListService.execute();
    }

}
