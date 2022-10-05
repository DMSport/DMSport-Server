package com.project.dmsport.domain.notice.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class NoAuthorityException extends BusinessException {
    public static final BusinessException EXCEPTION = new NoAuthorityException();
    private NoAuthorityException() {
        super(ErrorCode.NO_AUTHORITY);
    }
}
