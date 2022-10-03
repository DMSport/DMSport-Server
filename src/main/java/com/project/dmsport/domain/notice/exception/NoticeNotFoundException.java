package com.project.dmsport.domain.notice.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class NoticeNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new NoticeNotFoundException();
    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
