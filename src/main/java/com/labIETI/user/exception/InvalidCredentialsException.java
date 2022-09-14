package com.labIETI.user.exception;

import com.labIETI.user.dto.ServerErrorResponseDto;
import com.labIETI.user.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException(){

        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND).getMessage());

    }
}
