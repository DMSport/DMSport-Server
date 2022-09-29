package com.project.dmsport.domain.user.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class UserAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserAlreadyExistException();
    private UserAlreadyExistException(){
        super(ErrorCode.USER_ALREADY_EXIST);
    }
}