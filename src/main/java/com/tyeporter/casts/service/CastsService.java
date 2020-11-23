package com.tyeporter.casts.service;

import com.tyeporter.casts.model.Episode;
import com.tyeporter.casts.model.EpisodeSearchResults;
import com.tyeporter.casts.model.PodcastSearchResults;

public interface CastsService {

    public PodcastSearchResults searchPodcasts(String query);
    public EpisodeSearchResults searchEpisodes(String query);
    public EpisodeSearchResults getEpisodes(String topic, int genreId);
    public Episode getEpisode(String id);
    
}
