package com.app.session.exception;

import com.app.session.constant.ErrorCode;

public class CustomAuthenticationException extends RuntimeException{
    public CustomAuthenticationException() {
        super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
    }

    public CustomAuthenticationException(String message) {
        super(message);
    }
}
