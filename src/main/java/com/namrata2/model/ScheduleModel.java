package com.namrata2.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pojo to hold all schedule data
 */
@JsonInclude

public class ScheduleModel {
    @JsonProperty("id")
    private String id;

    @JsonProperty("line")
    private String line;

    @JsonProperty("departure")
    private String departure;

    @JsonProperty("arrival")
    private String arrival;

    public ScheduleModel() {

    }

    public ScheduleModel(final String id, final String line, final String departure, final String arrival) {
        this.id = id;
        this.line = line;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}
