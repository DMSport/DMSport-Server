package com.project.dmsport.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_TOKEN(401,"AUTH-401-1", "Expired Token" ),
    INVALID_TOKEN(401,"AUTH-401-2","Invalid Token"),

    INVALID_USER(401, "AUTH-401-3", "Invalid User"),
    REFRESH_TOKEN_NOT_FOUND(404, "AUTH-404-1", "Refresh Token Not Found"),

    BAD_EMAIL(400, "USER-400-1", "Bad Email Domain"),
    BAD_AUTH_CODE(401, "USER-401-1", "Bad Auth Code"),

    UNVERIFIED_EMAIL(401, "USER-401-1", "Unverified Email"),
    PASSWORD_NOT_VALID(401, "USER-401-1", "Password Not Valid"),
    USER_NOT_FOUND(404, "USER-404-2", "User Not Found" ),
    USER_ALREADY_EXIST(409, "USER-409-1", "User Already Exist"),

    MAIL_SEND_FAIL(404, "MAIL-404-1", "Mail Send Fail"),

    NOTICE_NOT_FOUND(404, "NOTICE-404-1", "Notice Not found"),
    NO_AUTHORITY(403, "NOTICE-403-1", "No authority"),

    CLUB_NOT_FOUND(404, "CLUB-404-1", "Club Not Found"),

    CLUB_MANAGER_NOT_FOUND(404, "CLUBMANAGER-404-1", "Club Manager Not Found"),

    CLUB_SCHEDULE_ALREADY_EXISTS(409, "CLUBSCHEDULE-409-1", "Club Schedule Already Exists"),

    VOTE_NOT_FOUND(404, "VOTE-404-1", "Vote Not Found"),

    FORBIDDEN(403, "COMMON-403-1", "Forbidden"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error");

    private final Integer status;
    private final String code;
    private final String message;
}
