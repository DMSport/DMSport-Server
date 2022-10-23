package com.project.dmsport.domain.notice.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class InvalidAuthorityException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidAuthorityException();
    private InvalidAuthorityException() {
        super(ErrorCode.NO_AUTHORITY);
    }
}
