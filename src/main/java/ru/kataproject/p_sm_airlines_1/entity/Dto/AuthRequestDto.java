package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * class used in authentication, that provides username and password
 */
@RequiredArgsConstructor
@Getter
public class AuthRequestDto {
    private final String username;
    private final String password;
}
