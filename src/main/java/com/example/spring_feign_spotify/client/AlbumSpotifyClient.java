package com.example.spring_feign_spotify.client;

import com.example.spring_feign_spotify.dtos.AlbumResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumSpotifyClient",
        url = "https://api.spotify.com/v1/browse"
)
public interface AlbumSpotifyClient {

    @GetMapping(value = "/new-releases")
    AlbumResponseDTO getReleases(@RequestHeader("Authorization") String authorization);
}
