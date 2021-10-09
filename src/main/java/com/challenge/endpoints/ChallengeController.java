package com.challenge.endpoints;

import com.challenge.entity.Challenge;

import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// https://receitasdecodigo.com.br/spring-framework/diferenca-entre-@pathvariable-e-@requestparam-do-spring-mvc

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @GetMapping
    public List<Challenge> findAll(@RequestParam("accelerationId") Long accelerationId,
                                   @RequestParam("userId") Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
