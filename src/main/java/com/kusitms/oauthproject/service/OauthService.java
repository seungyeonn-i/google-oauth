package com.kusitms.oauthproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kusitms.oauthproject.dto.GoogleOauthToken;
import com.kusitms.oauthproject.dto.GoogleUser;
import com.kusitms.oauthproject.repository.GoogleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final GoogleOauth googleOauth;
    private final GoogleUserRepository googleUserRepository;

    private final HttpServletResponse response;

    public void request(String socialLoginType) throws IOException{
        String redirectURL = googleOauth.getOauthRedirectURL();
        response.sendRedirect(redirectURL);
    }

    public void oauthLogin(String socialLoginType, String code) throws JsonProcessingException {

        ResponseEntity<String> accessTokenResponse = googleOauth.requestAccessToken(code);
        GoogleOauthToken OAuthToken = googleOauth.getAccessToken(accessTokenResponse);
        ResponseEntity<String> userInfoResponse = googleOauth.requestUserInfo(OAuthToken);
        GoogleUser googleUser = googleOauth.getUserInfo(userInfoResponse);
        googleUserRepository.save(googleUser);

    }

}
