package com.project.dmsport.domain.user.presentation;

import com.project.dmsport.domain.auth.presentation.dto.response.TokenResponse;
import com.project.dmsport.domain.user.presentation.dto.request.CheckEmailRequest;
import com.project.dmsport.domain.user.presentation.dto.request.FindPasswordRequest;
import com.project.dmsport.domain.user.presentation.dto.request.LoginRequest;
import com.project.dmsport.domain.user.presentation.dto.request.SendAuthCodeRequest;
import com.project.dmsport.domain.user.presentation.dto.request.SignupRequest;
import com.project.dmsport.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.project.dmsport.domain.user.presentation.dto.request.VerifyAuthCodeRequest;
import com.project.dmsport.domain.user.presentation.dto.request.WithdrawalRequest;
import com.project.dmsport.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.project.dmsport.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final CheckEmailService checkEmailService;
    private final SendSignupAuthCodeService sendSignupAuthCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;

    private final SignupService signupService;
    private final LoginService loginService;
    private final TokenRefreshService tokenRefreshService;

    private final UpdatePasswordService updatePasswordService;

    private final SendPasswordFindCodeService sendPasswordCodeService;
    private final FindPasswordService findPasswordService;

    private final LogoutService logoutService;
    private final WithdrawalService withdrawalService;

    private final QueryMyInfoService queryMyInfoService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/duplicate")
    public void checkEmail(@RequestBody @Valid CheckEmailRequest request){
        checkEmailService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/signup")
    public void sendSignupAuthCodeService(@RequestBody @Valid SendAuthCodeRequest request){
        sendSignupAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/verify")
    public void verifyAuthCode(@RequestBody @Valid VerifyAuthCodeRequest request) {
        verifyAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse signup(@RequestBody @Valid SignupRequest request){
        return signupService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return loginService.execute(request);
    }

    @PutMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("X-Refresh-Token") String refreshToken){
        return tokenRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updateUserPassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/find")
    public void sendPasswordFindCodeService(@RequestBody @Valid SendAuthCodeRequest request){
        sendPasswordCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/password")
    public void findPassword(@RequestBody @Valid FindPasswordRequest request) {
        findPasswordService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout(){
        logoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void withdrawal(@RequestBody @Valid WithdrawalRequest request){
        withdrawalService.execute(request);
    }

    @GetMapping("/my")
    public QueryMyInfoResponse myInfo() {
        return queryMyInfoService.execute();
    }
}