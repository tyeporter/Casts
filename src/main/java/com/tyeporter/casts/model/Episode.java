package com.tyeporter.casts.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {

    // COMMON

    @JsonProperty("id")
    private String id;

    @JsonProperty("pub_date_ms")
    private Long publishedDate;

    @JsonProperty("audio")
    private String audio;

    @JsonProperty("audio_length_sec")
    private int audioLength;

    @JsonProperty("listennotes_url")
    private String listennotesUrl;

    @JsonProperty("image")
    private String image;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("explicit_content")
    private Boolean explicitContent;

    @JsonProperty("link")
    private String link;

    @JsonProperty("podcast")
    private Podcast podcast;
    
    // EPISODE

    @JsonProperty(value = "title", required = false)
    private String title;

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty(value = "maybe_audio_invalid", required = false)
    private Boolean maybeAudioInvalid;

    @JsonProperty(value = "listennotes_edit_url", required = false)
    private String listennotesEditUrl;

    // SEARCH

    @JsonProperty(value = "rss", required = false)
    private String rss;

    @JsonProperty(value = "description_highlighted", required = false)
    private String descriptionHighlighted;

    @JsonProperty(value = "description_original", required = false)
    private String descriptionOriginal;

    @JsonProperty(value = "title_highlighted", required = false)
    private String titleHighlighted;

    @JsonProperty(value = "title_original", required = false)
    private String titleOriginal;

    @JsonProperty(value = "transcripts_highlighted", required = false)
    private List<String> transcriptsHighlighted;

    @JsonProperty(value = "itunes_id", required = false)
    private Long itunesId;

    public Episode() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishedDate() {
        Date date = new Date(this.publishedDate);
        LocalDateTime dateAsLDT = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		return dateAsLDT.format(dateFormatter);
    }

    public void setPublishedDate(Long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudioLength() {
        System.out.println();
        return audioLength / 60 + " mins " + audioLength % 60 + " sec";
    }

    public void setAudioLength(int audioLength) {
        this.audioLength = audioLength;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
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

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMaybeAudioInvalid() {
        return maybeAudioInvalid;
    }

    public void setMaybeAudioInvalid(Boolean maybeAudioInvalid) {
        this.maybeAudioInvalid = maybeAudioInvalid;
    }

    public String getListennotesEditUrl() {
        return listennotesEditUrl;
    }

    public void setListennotesEditUrl(String listennotesEditUrl) {
        this.listennotesEditUrl = listennotesEditUrl;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
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

    public List<String> getTranscriptsHighlighted() {
        return transcriptsHighlighted;
    }

    public void setTranscriptsHighlighted(List<String> transcriptsHighlighted) {
        this.transcriptsHighlighted = transcriptsHighlighted;
    }

    public Long getItunesId() {
        return itunesId;
    }

    public void setItunesId(Long itunesId) {
        this.itunesId = itunesId;
    }

    public List<String> getGenres() {
        List<String> genres = new ArrayList<>();

        for (int i = 0; i < this.getPodcast().getGenreIds().size(); i++) {
            genres.add(Genres.getGenre(this.getPodcast().getGenreIds().get(i)));
            if (i == 2) { break; }
        }

        return genres;
    }

    @Override
    public String toString() {
        return "Episode [audio=" + audio + ", audioLength=" + audioLength + ", description=" + description
                + ", descriptionHighlighted=" + descriptionHighlighted + ", descriptionOriginal=" + descriptionOriginal
                + ", explicitContent=" + explicitContent + ", id=" + id + ", image=" + image + ", itunesId=" + itunesId
                + ", link=" + link + ", listennotesEditUrl=" + listennotesEditUrl + ", listennotesUrl=" + listennotesUrl
                + ", maybeAudioInvalid=" + maybeAudioInvalid + ", podcast=" + podcast + ", publishedDate="
                + publishedDate + ", rss=" + rss + ", thumbnail=" + thumbnail + ", title=" + title
                + ", titleHighlighted=" + titleHighlighted + ", titleOriginal=" + titleOriginal
                + ", transcriptsHighlighted=" + transcriptsHighlighted + "]";
    }   
    
}
