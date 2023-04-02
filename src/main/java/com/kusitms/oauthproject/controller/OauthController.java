package com.kusitms.oauthproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kusitms.oauthproject.dto.GoogleOauthToken;
import com.kusitms.oauthproject.dto.GoogleUser;
import com.kusitms.oauthproject.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class OauthController {

    private final OauthService oauthService;

    @GetMapping(value = "/{socialLoginType}")
    public void socialLoginType(@PathVariable(name = "socialLoginType") String socialLoginType) throws IOException {

        oauthService.request(socialLoginType);
    }

    @GetMapping(value="/{socialLoginType}/callback")
    public void callback(
            @PathVariable(name="socialLoginType") String socialLoginType,
            @RequestParam(name="code") String code) throws JsonProcessingException {
        oauthService.oauthLogin(socialLoginType, code);
//

    }



}
