package com.project.dmsport.domain.user.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class BadAuthCodeException extends BusinessException {
    public static final BusinessException EXCEPTION = new BadAuthCodeException();
    private BadAuthCodeException(){
        super(ErrorCode.BAD_AUTH_CODE);
    }
}