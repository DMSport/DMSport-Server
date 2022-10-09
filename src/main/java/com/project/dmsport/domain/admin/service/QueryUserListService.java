package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.response.UserListResponse;
import com.project.dmsport.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryUserListService {
    private final UserRepository userRepository;

    public List<UserListResponse> execute() {

        return userRepository.findAllOrderByIdDesc()
                .stream()
                .map(user-> UserListResponse.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .authority(user.getAuthority())
                                .build())
                .collect(Collectors.toList());
    }

}
