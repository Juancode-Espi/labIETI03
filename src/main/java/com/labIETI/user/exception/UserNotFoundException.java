package com.labIETI.user.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String USER_NOT_FOUND= "USER NOT FOUND";

    public UserNotFoundException(){
        super(USER_NOT_FOUND);
    }
}
