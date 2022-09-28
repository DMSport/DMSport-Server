package com.project.dmsport.global.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ForbiddenException extends BusinessException {
    public static final BusinessException EXCEPTION = new ForbiddenException();
    private ForbiddenException(){
        super(ErrorCode.FORBIDDEN);
    }
}