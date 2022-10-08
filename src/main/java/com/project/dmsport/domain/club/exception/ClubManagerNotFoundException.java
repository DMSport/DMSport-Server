package com.project.dmsport.domain.club.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ClubManagerNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ClubManagerNotFoundException();

    private ClubManagerNotFoundException() {
        super(ErrorCode.CLUB_MANAGER_NOT_FOUND);
    }

}
