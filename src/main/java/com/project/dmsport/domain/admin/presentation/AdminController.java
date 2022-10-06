package com.project.dmsport.domain.admin.presentation;

import com.project.dmsport.domain.admin.presentation.dto.response.UserResponse;
import com.project.dmsport.domain.admin.service.SearchAllUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final SearchAllUsersService searchAllUsersService;
    @GetMapping("/users")
    public List<UserResponse> searchAllUsers() {
        return searchAllUsersService.execute();
    }
}
