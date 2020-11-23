package com.tyeporter.casts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PodcastLookingFor {

    @JsonProperty("sponsers")
    private boolean sponsers;

    @JsonProperty("guests")
    private boolean guests;

    @JsonProperty("cohosts")
    private boolean cohosts;

    @JsonProperty("cross_promotion")
    private boolean crossPromotion;
    
    public PodcastLookingFor() {}

    public boolean getSponsers() {
        return sponsers;
    }

    public void setSponsers(boolean sponsers) {
        this.sponsers = sponsers;
    }

    public boolean getGuests() {
        return guests;
    }

    public void setGuests(boolean guests) {
        this.guests = guests;
    }

    public boolean getCohosts() {
        return cohosts;
    }

    public void setCohosts(boolean cohosts) {
        this.cohosts = cohosts;
    }

    public boolean getCrossPromotion() {
        return crossPromotion;
    }

    public void setCrossPromotion(boolean crossPromotion) {
        this.crossPromotion = crossPromotion;
    }

}