package com.tyeporter.casts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PodcastExtra {

    @JsonProperty("twitter_handle")
    private String twitterHandle;
    
    @JsonProperty("facebook_handle")
    private String facebookHandle;
    
    @JsonProperty("instagram_handle")
    private String instagramHandle;
    
    @JsonProperty("wechat_handle")
    private String wechatHandle;
    
    @JsonProperty("patreon_handle")
    private String patreonHandle;
    
    @JsonProperty("youtube_url")
    private String youtubeUrl;
    
    @JsonProperty("linkedin_url")
    private String linkedinUrl;
    
    @JsonProperty("spotify_url")
    private String spotifyUrl;
    
    @JsonProperty("google_url")
    private String googleUrl;
    
    @JsonProperty("url1")
    private String url1;
    
    @JsonProperty("url2")
    private String url2;
    
    @JsonProperty("url3")
    private String url3;

    public PodcastExtra() {}

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getFacebookHandle() {
        return facebookHandle;
    }

    public void setFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    public String getWechatHandle() {
        return wechatHandle;
    }

    public void setWechatHandle(String wechatHandle) {
        this.wechatHandle = wechatHandle;
    }

    public String getPatreonHandle() {
        return patreonHandle;
    }

    public void setPatreonHandle(String patreonHandle) {
        this.patreonHandle = patreonHandle;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

}