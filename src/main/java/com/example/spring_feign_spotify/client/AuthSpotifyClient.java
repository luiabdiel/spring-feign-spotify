package com.example.spring_feign_spotify.client;

import com.example.spring_feign_spotify.dtos.LoginRequestDTO;
import com.example.spring_feign_spotify.dtos.LoginResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "AuthSpotifyClient",
        url = "https://accounts.spotify.com/api"
)
public interface AuthSpotifyClient {

    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    LoginResponseDTO loginResponse(@RequestBody LoginRequestDTO loginRequest);
}
