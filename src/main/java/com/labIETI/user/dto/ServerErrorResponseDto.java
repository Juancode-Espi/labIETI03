package com.labIETI.user.dto;

import com.labIETI.user.enums.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerErrorResponseDto {

    String message;
    ErrorCodeEnum errorCode;
    int httpSatus;

    public ServerErrorResponseDto(String message, ErrorCodeEnum errorCode, HttpStatus httpStatus){
        this.message = message;
        this.errorCode = errorCode;
        this.httpSatus = httpStatus.value();
    }
}
