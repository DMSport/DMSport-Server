package com.project.dmsport.domain.vote.exception;

import com.project.dmsport.global.error.exception.BusinessException;
import com.project.dmsport.global.error.exception.ErrorCode;

public class VoteNotFound extends BusinessException {

    public static final BusinessException EXCEPTION =
            new VoteNotFound();

    private VoteNotFound() {
        super(ErrorCode.VOTE_NOT_FOUND);
    }

}
