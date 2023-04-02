package com.kusitms.oauthproject.repository;

import com.kusitms.oauthproject.dto.GoogleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleUserRepository extends JpaRepository<GoogleUser,String> {
}

