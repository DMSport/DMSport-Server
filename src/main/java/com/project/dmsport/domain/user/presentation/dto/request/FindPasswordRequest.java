package com.project.dmsport.domain.user.presentation.dto.request;

import com.project.dmsport.global.util.RegexpProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class FindPasswordRequest {

    @NotBlank(message = "new_password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = RegexpProperty.PASSWORD, message = "password는 대소문자, 특수문자 포함 8-30자여야합니다.")
    String newPassword;
}