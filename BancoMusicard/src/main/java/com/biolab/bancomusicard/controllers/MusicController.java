package com.biolab.bancomusicard.controllers;

import com.biolab.bancomusicard.services.MusicBrainzService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicController {

    private final MusicBrainzService musicBrainzService;

    public MusicController(MusicBrainzService musicBrainzService) {
        this.musicBrainzService = musicBrainzService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<String> buscar(@RequestParam String query) {
        String resultado = musicBrainzService.pesquisarArtistaOuAlbum(query);
        return ResponseEntity.ok(resultado);
    }
}
