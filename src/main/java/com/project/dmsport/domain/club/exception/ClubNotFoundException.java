package com.project.dmsport.domain.club.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ClubNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ClubNotFoundException();

    private ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}
