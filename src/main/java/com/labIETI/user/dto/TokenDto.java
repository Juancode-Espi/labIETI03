package com.labIETI.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@AllArgsConstructor
public class TokenDto {

    private String token;
    private Date expirationDate;
}
