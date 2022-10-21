package com.project.dmsport.domain.club.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class ClubScheduleAlreadyExistException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ClubScheduleAlreadyExistException();

    private ClubScheduleAlreadyExistException() {
        super(ErrorCode.CLUB_SCHEDULE_ALREADY_EXISTS);
    }

}
