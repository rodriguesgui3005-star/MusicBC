package com.biolab.bancomusicard.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MusicBrainzService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://musicbrainz.org/ws/2/";

    public String pesquisarArtistaOuAlbum(String termo) {
        String url = BASE_URL + "release?query=" + termo + "&fmt=json";

        // Cabeçalho Obrigatório exigido pela MusicBrainz
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MusicardTCC/1.0.0 ( contato@musicard.com )");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
