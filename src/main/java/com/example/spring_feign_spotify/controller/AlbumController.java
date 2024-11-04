package com.example.spring_feign_spotify.controller;

import com.example.spring_feign_spotify.client.AlbumSpotifyClient;
import com.example.spring_feign_spotify.client.AuthSpotifyClient;
import com.example.spring_feign_spotify.dtos.AlbumDTO;
import com.example.spring_feign_spotify.dtos.AlbumResponseDTO;
import com.example.spring_feign_spotify.dtos.LoginRequestDTO;
import com.example.spring_feign_spotify.dtos.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/spotify/api")
@RequiredArgsConstructor
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getAlbums() {
        var request = new LoginRequestDTO(
                "client_credentials",
                "your_client_id",
                "your_client_secret"
        );

        var token = authSpotifyClient.loginResponse(request).getAccessToken();
        var response = albumSpotifyClient.getReleases("Bearer " + token);

        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
