package com.project.dmsport.domain.auth.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class RefreshTokenNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new RefreshTokenNotFoundException();
    private RefreshTokenNotFoundException(){
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}