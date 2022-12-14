package com.project.dmsport.domain.user.facade;

import com.project.dmsport.domain.user.domain.AuthCode;
import com.project.dmsport.domain.user.domain.repository.AuthCodeRepository;
import com.project.dmsport.domain.user.exception.BadAuthCodeException;
import com.project.dmsport.domain.user.exception.BadEmailException;
import com.project.dmsport.domain.user.exception.UnverifiedEmailException;
import com.project.dmsport.global.util.RandomUtil;
import com.project.dmsport.global.util.RegexpProperty;
import com.project.dmsport.global.util.jms.JmsProperties;
import com.project.dmsport.global.util.jms.JmsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;
    private final JmsUtil jmsUtil;
    private final JmsProperties jmsProperties;

    public void verifyAuthCode(String code, String email) {

        AuthCode authCode = authCodeRepository.findById(email)
                .filter(a -> a.getCode().equals(code))
                .orElseThrow(() -> BadAuthCodeException.EXCEPTION);

        authCode.verify();
        authCodeRepository.save(authCode);
    }

    public void checkIsVerified(String email) {
        authCodeRepository.findById(email)
                .filter(AuthCode::isVerified)
                .orElseThrow(() -> UnverifiedEmailException.EXCEPTION);
    }

    public void checkEmailDomain(String email) {
        if(!email.matches(RegexpProperty.EMAIL)) {
            throw BadEmailException.EXCEPTION;
        }
    }

    public void sendMail(String email) {

        String code = RandomUtil.createRandomCode();
        AuthCode authCode = getAuthCode(email, code);
        authCodeRepository.save(authCode);

        jmsUtil.sendMail(email, authCode.getCode());
    }

    private AuthCode getAuthCode(String email, String code) {

        AuthCode authCode = authCodeRepository.findById(email)
                .orElseGet(() -> createAuthCode(email, code));

        authCode.updateAuthCode(code, jmsProperties.getAuthExp());

        return authCode;
    }

    private AuthCode createAuthCode(String email, String code) {
        return AuthCode
                .builder()
                .email(email)
                .code(code)
                .isVerified(false)
                .ttl(jmsProperties.getAuthExp())
                .build();
    }

}