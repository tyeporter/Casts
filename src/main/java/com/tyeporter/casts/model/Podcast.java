package com.tyeporter.casts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Podcast {

	// COMMON

	@JsonProperty("id")
	private String id;

	@JsonProperty("image")
	private String image;

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("listennotes_url")
	private String url;

	@JsonProperty("listen_score")
	private String listenScore;

	@JsonProperty("listen_score_global_rank")
	private String listenScoreGlobalRank;

	@JsonProperty("genre_ids")
	private List<Integer> genreIds;

	// PODCAST

	@JsonProperty("title")
	private String title;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("total_episodes")
	private int totalEpisodes;

	@JsonProperty("explicit_content")
	private boolean explicitContent;

	@JsonProperty("description")
	private String description;

	@JsonProperty("itunes_id")
	private long itunesId;

	@JsonProperty("rss")
	private String rss;

	@JsonProperty("latest_pub_date_ms")
	private long latestPublishedDate;

	@JsonProperty("earliest_pub_date_ms")
	private long earliestPublishedDate;

	@JsonProperty("language")
	private String language;

	@JsonProperty("country")
	private String country;

	@JsonProperty("website")
	private String website;

	@JsonProperty("extra")
	private PodcastExtra extra;

	@JsonProperty("is_claimed")
	private boolean isClaimed;

	@JsonProperty("email")
	private String email;

	@JsonProperty("type")
	private String type;

	@JsonProperty("looking_for")
	private PodcastLookingFor lookingFor;

	// SEARCH

	@JsonProperty("description_highlighted")
	private String descriptionHighlighted;
	
	@JsonProperty("description_original")
    private String descriptionOriginal;

	@JsonProperty("title_highlighted")
	private String titleHighlighted;
	
	@JsonProperty("title_original")
    private String titleOriginal;

	@JsonProperty("publisher_highlighted")
	private String publisherHighlighted;
	
    @JsonProperty("publisher_original")
    private String publisherOriginal;
	
	public Podcast() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getListenScore() {
		return listenScore;
	}

	public void setListenScore(String listenScore) {
		this.listenScore = listenScore;
	}

	public String getListenScoreGlobalRank() {
		return listenScoreGlobalRank;
	}

	public void setListenScoreGlobalRank(String listenScoreGlobalRank) {
		this.listenScoreGlobalRank = listenScoreGlobalRank;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getTotalEpisodes() {
		return totalEpisodes;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public boolean getExplicitContent() {
		return explicitContent;
	}

	public void setExplicitContent(boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getItunesId() {
		return itunesId;
	}

	public void setItunesId(long itunesId) {
		this.itunesId = itunesId;
	}

	public String getRss() {
		return rss;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public long getLatestPublishedDate() {
		return latestPublishedDate;
	}

	public void setLatestPublishedDate(long latestPublishedDate) {
		this.latestPublishedDate = latestPublishedDate;
	}

	public long getEarliestPublishedDate() {
		return earliestPublishedDate;
	}

	public void setEarliestPublishedDate(long earliestPublishedDate) {
		this.earliestPublishedDate = earliestPublishedDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public PodcastExtra getExtra() {
		return extra;
	}

	public void setExtra(PodcastExtra extra) {
		this.extra = extra;
	}

	public boolean getIsClaimed() {
		return isClaimed;
	}

	public void setIsClaimed(boolean isClaimed) {
		this.isClaimed = isClaimed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PodcastLookingFor getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(PodcastLookingFor lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getDescriptionHighlighted() {
		return descriptionHighlighted;
	}
	
	public void setDescriptionHighlighted(String descriptionHighlighted) {
		this.descriptionHighlighted = descriptionHighlighted;
	}

	public String getDescriptionOriginal() {
		return descriptionOriginal;
	}

	public void setDescriptionOriginal(String descriptionOriginal) {
		this.descriptionOriginal = descriptionOriginal;
	}

	public String getTitleHighlighted() {
		return titleHighlighted;
	}

	public void setTitleHighlighted(String titleHighlighted) {
		this.titleHighlighted = titleHighlighted;
	}

	public String getTitleOriginal() {
		return titleOriginal;
	}

	public void setTitleOriginal(String titleOriginal) {
		this.titleOriginal = titleOriginal;
	}

	public String getPublisherHighlighted() {
		return publisherHighlighted;
	}

	public void setPublisherHighlighted(String publisherHighlighted) {
		this.publisherHighlighted = publisherHighlighted;
	}

	public String getPublisherOriginal() {
		return publisherOriginal;
	}

	public void setPublisherOriginal(String publisherOriginal) {
		this.publisherOriginal = publisherOriginal;
	}

	@Override
	public String toString() {
		return "Podcast [country=" + country + ", description=" + description + ", descriptionHighlighted="
				+ descriptionHighlighted + ", descriptionOriginal=" + descriptionOriginal + ", earliestPublishedDate="
				+ earliestPublishedDate + ", email=" + email + ", explicitContent=" + explicitContent + ", extra="
				+ extra + ", genreIds=" + genreIds + ", id=" + id + ", image=" + image + ", isClaimed=" + isClaimed
				+ ", itunesId=" + itunesId + ", language=" + language + ", latestPublishedDate=" + latestPublishedDate
				+ ", listenScore=" + listenScore + ", listenScoreGlobalRank=" + listenScoreGlobalRank + ", lookingFor="
				+ lookingFor + ", publisher=" + publisher + ", publisherHighlighted=" + publisherHighlighted
				+ ", publisherOriginal=" + publisherOriginal + ", rss=" + rss + ", thumbnail=" + thumbnail + ", title="
				+ title + ", titleHighlighted=" + titleHighlighted + ", titleOriginal=" + titleOriginal
				+ ", totalEpisodes=" + totalEpisodes + ", type=" + type + ", url=" + url + ", website=" + website + "]";
	}

	
}