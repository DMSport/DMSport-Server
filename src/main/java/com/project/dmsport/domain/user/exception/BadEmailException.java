package com.project.dmsport.domain.user.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class BadEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new BadEmailException();
    private BadEmailException(){
        super(ErrorCode.BAD_EMAIL);
    }
}