package com.kusitms.oauthproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GoogleOauthToken {
    private String access_token;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String token_type;
    private String id_token;
}
