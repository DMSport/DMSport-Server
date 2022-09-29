package com.project.dmsport.domain.user.presentation.dto.request;

import com.project.dmsport.global.util.RegexpProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignupRequest {

    @NotBlank(message = "name은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 30)
    private String name;

    @Size(max = 40)
    @Pattern(regexp = RegexpProperty.EMAIL)
    private String email;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = RegexpProperty.PASSWORD, message = "password는 대소문자, 특수문자 포함 8-30자여야합니다.")
    private String password;
}