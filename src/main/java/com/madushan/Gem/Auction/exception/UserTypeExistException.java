package com.madushan.Gem.Auction.exception;

public class UserTypeExistException extends RuntimeException{

    public UserTypeExistException() {
    }

    public UserTypeExistException(String message) {
        super(message);
    }
}
