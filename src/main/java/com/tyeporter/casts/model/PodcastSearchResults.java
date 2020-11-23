package com.tyeporter.casts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PodcastSearchResults {

	@JsonProperty("count")
    private int count;

    @JsonProperty("next_offset")
    private int nextOffset;

    @JsonProperty("total")
    private int total;

    @JsonProperty("took")
    private double took;
	
	@JsonProperty("results")
	List<Podcast> podcasts;

	public PodcastSearchResults() {}

	public double getTimeTook() {
		return took;
	}

	public void setTimeTook(double timeTook) {
		this.took = timeTook;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNextOffset() {
		return nextOffset;
	}

	public void setNextOffset(int nextOffset) {
		this.nextOffset = nextOffset;
	}

	public List<Podcast> getPodcasts() {
		return podcasts;
	}

	public void setPodcasts(List<Podcast> podcasts) {
		this.podcasts = podcasts;
	}

	@Override
	public String toString() {
		return "PodcastSearchResults [count=" + count + ", nextOffset=" + nextOffset + ", podcasts=" + podcasts
				+ ", took=" + took + ", total=" + total + "]";
	}

}