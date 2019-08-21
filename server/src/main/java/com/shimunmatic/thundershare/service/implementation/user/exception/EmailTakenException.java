package com.shimunmatic.thundershare.service.implementation.user.exception;

public class EmailTakenException extends Exception {

    public EmailTakenException() {
        super("Email already taken");
    }
}
