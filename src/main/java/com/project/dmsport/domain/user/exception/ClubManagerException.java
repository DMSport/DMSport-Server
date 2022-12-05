package com.project.dmsport.domain.user.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ClubManagerException extends BusinessException {
    public static final BusinessException EXCEPTION = new ClubManagerException();
    private ClubManagerException(){
        super(ErrorCode.CLUB_MANAGER_CANNOT_DELETE);
    }
}
