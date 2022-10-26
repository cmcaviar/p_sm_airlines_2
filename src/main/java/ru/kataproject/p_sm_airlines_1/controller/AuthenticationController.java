package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface AuthenticationController {
    @GetMapping("/tokens")
    @Operation(summary = "Get all available tokens", description = "Get a Map that contains access token, refresh token," +
            "id token amd expiration time for the access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successful operation", content = {
                    @Content(mediaType = "application/json")
            })
    })
    Map<String, String> getAllTokensAsStrings();
}
