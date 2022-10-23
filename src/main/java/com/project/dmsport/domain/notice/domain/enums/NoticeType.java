package com.project.dmsport.domain.notice.domain.enums;

import com.project.dmsport.domain.notice.exception.InvalidAuthorityException;
import com.project.dmsport.domain.user.domain.enums.Authority;

public enum NoticeType {
    ALL,
    BASKETBALL,
    SOCCER,
    BADMINTON,
    VOLLEYBALL;

    public static NoticeType getByAuthority(Authority authority) {
        switch (authority) {
            case BADMINTON_MANAGER:
                return NoticeType.BADMINTON;
            case BASKETBALL_MANAGER:
                return NoticeType.BASKETBALL;
            case SOCCER_MANAGER:
                return NoticeType.SOCCER;
            case VOLLEYBALL_MANAGER:
                return NoticeType.VOLLEYBALL;
        }
        throw InvalidAuthorityException.EXCEPTION;
    }

}
