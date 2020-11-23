package com.tyeporter.casts.service;

import com.tyeporter.casts.model.Episode;
import com.tyeporter.casts.model.EpisodeSearchResults;
import com.tyeporter.casts.model.PodcastSearchResults;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CastsServiceImpl implements CastsService {

    @Value("${api_key}")
    private String apiKey;
    HttpHeaders headers;
    HttpEntity<String> entity;

    public CastsServiceImpl() {
        this.headers = new HttpHeaders();
        headers.set("X-ListenAPI-Key", apiKey);
        this.entity = new HttpEntity<>(headers);
    }

    @Override
    @Cacheable("searchPodcasts")
    public PodcastSearchResults searchPodcasts(String query) {
        String url = "https://listen-api.listennotes.com/api/v2/search?q=" + query + "&sort_by_date=0&type=podcast&offset=0&len_min=10&len_max=30&published_before=0&published_after=0&only_in=author&language=English&safe_mode=0";

        RestTemplate template = new RestTemplate();

        ResponseEntity<PodcastSearchResults> response = template.exchange(url, HttpMethod.GET, this.entity, PodcastSearchResults.class);

        System.out.println(response.getBody());
        System.out.println("Status: " + response.getStatusCode().value());
        return response.getBody();
    }

    @Override
    @Cacheable("searchEpisodes")
    public EpisodeSearchResults searchEpisodes(String query) {
        String url = "https://listen-api.listennotes.com/api/v2/search?q=" + query + "&sort_by_date=0&type=episode&offset=0&len_min=10&len_max=30&published_before=0&published_after=0&only_in=title%2Cdescription&language=English&safe_mode=0";

        RestTemplate template = new RestTemplate();

        ResponseEntity<EpisodeSearchResults> response = template.exchange(url, HttpMethod.GET, this.entity, EpisodeSearchResults.class);

        System.out.println(response.getBody());
        System.out.println("Status: " + response.getStatusCode().value());
        return response.getBody();
    }

    @Override
    @Cacheable("getEpisodes")
    public EpisodeSearchResults getEpisodes(String topic, int genreId) {
        String url = "https://listen-api.listennotes.com/api/v2/search?q=" + topic + "&sort_by_date=1&type=episode&offset=0&len_min=10&len_max=30&genre_ids=" + genreId + "&published_before=0&published_after=0&only_in=description&language=English&safe_mode=0";

        RestTemplate template = new RestTemplate();

        ResponseEntity<EpisodeSearchResults> response = template.exchange(url, HttpMethod.GET, this.entity, EpisodeSearchResults.class);

        return response.getBody();
    }

    @Override
    @Cacheable("getEpisode")
    public Episode getEpisode(String id) {
        String url = "https://listen-api.listennotes.com/api/v2/episodes/" + id;

        RestTemplate template = new RestTemplate();

        ResponseEntity<Episode> response = template.exchange(url, HttpMethod.GET, this.entity, Episode.class);

        return response.getBody();
    }
    
}
