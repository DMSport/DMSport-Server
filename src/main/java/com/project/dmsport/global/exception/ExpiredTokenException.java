package com.project.dmsport.global.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new ExpiredTokenException();
    private ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}