package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.response.UserResponse;
import com.project.dmsport.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchAllUsersService {
    private final UserRepository userRepository;

    public List<UserResponse> execute() {
        return userRepository.findAllOrderByIdDesc().stream().map(
                u->
                        UserResponse.builder()
                                .id(u.getId())
                                .name(u.getName())
                                .authority(u.getAuthority())
                                .build()
                ).collect(Collectors.toList());
    }
}
