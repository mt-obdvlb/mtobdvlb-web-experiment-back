package com.mtobdvlb.exception;

public class AccountNotFoundException extends BaseException {
    public AccountNotFoundException() {
    }
    public AccountNotFoundException(String message) {
        super(message);
    }
}
