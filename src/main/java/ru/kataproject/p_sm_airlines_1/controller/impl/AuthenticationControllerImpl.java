package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.AuthenticationController;
import ru.kataproject.p_sm_airlines_1.service.keycloak_clients.ThrGreatBeanOfAllTokens;

import java.util.Map;

@RestController
public class AuthenticationControllerImpl implements AuthenticationController {
    private final ThrGreatBeanOfAllTokens bean;

    public AuthenticationControllerImpl(ThrGreatBeanOfAllTokens bean) {
        this.bean = bean;
    }

    @GetMapping("/tokens")
    public Map<String, String> getAllTokensAsStrings(){
        return bean.getTokens();
    }


}
