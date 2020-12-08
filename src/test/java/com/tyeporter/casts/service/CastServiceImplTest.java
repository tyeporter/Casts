package com.tyeporter.casts.service;

import com.tyeporter.casts.controller.CastsController.Category;
import com.tyeporter.casts.model.Episode;
import com.tyeporter.casts.model.EpisodeSearchResults;
import com.tyeporter.casts.model.PodcastSearchResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastServiceImplTest {

    private CastsServiceImpl castsService;

    @BeforeEach
    public void setup() {
        this.castsService = new CastsServiceImpl();
    }

    // =========================================================
    // Jupiter
    // =========================================================

    @Test
    public void testSearchPodcasts_GivenString_ShouldReturnPodcastSearchResults() {
        assertEquals(PodcastSearchResults.class, this.castsService.searchPodcasts("Joe").getClass());
    }

    @Test
    public void testSearchEpisodes_GivenString_ShouldReturnEpisodeSearchResults() {
        assertEquals(EpisodeSearchResults.class, this.castsService.searchEpisodes("Programming").getClass());
    }

    @ParameterizedTest
    @EnumSource(Category.class)
    public void testGetEpisodes_GivenStringAndInt_ReturnsEpisodeSearchResults(Category category) {
        assertEquals(EpisodeSearchResults.class, this.castsService.getEpisodes(category.getStringValue(), category.getId()).getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a2e6f0ab2a34cd289261d758946848b", "a8830437fad348bfb8b1e4dd50294868", "2245e20c59624469a3d7e27513d7237e", "688bc4672498432e81e380deff858065"})
    public void testGetEpisode_GivenString_ReturnsEpisode(String episodeId) {
        assertEquals(Episode.class, this.castsService.getEpisode(episodeId).getClass());
    }

}
