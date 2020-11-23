package com.tyeporter.casts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeSearchResults {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next_offset")
    private int nextOffset;

    @JsonProperty("total")
    private int total;

    @JsonProperty("took")
    private Double took;

    @JsonProperty("results")
    private List<Episode> episodes;

    public EpisodeSearchResults() {}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Double getTook() {
        return took;
    }

    public void setTook(Double took) {
        this.took = took;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "EpisodeSearchResults [count=" + count + ", episodes=" + episodes + ", nextOffset=" + nextOffset + ", took="
                + took + ", total=" + total + "]";
    }
    
}
