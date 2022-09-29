package com.project.dmsport.domain.user.presentation.dto.request;

import com.project.dmsport.global.util.RegexpProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CheckEmailRequest {

    @Size(max = 40)
    @Pattern(regexp = RegexpProperty.EMAIL)
    private String email;

}