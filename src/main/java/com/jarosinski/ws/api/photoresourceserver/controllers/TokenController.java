package com.jarosinski.ws.api.photoresourceserver.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping
    public Jwt token(@AuthenticationPrincipal Jwt jwt) {
        return jwt;
    }
}
